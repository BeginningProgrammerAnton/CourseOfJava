package com.example.ProjectPolovinkin.controllers;

import com.example.ProjectPolovinkin.helpers.TakeBookReq;
import com.example.ProjectPolovinkin.model.Book;
import com.example.ProjectPolovinkin.model.history.History;
import com.example.ProjectPolovinkin.model.User;
import com.example.ProjectPolovinkin.model.UserBook;
import com.example.ProjectPolovinkin.model.history.PopularBook;
import com.example.ProjectPolovinkin.model.history.PopularUsers;
import com.example.ProjectPolovinkin.model.repositories.BookRepository;
import com.example.ProjectPolovinkin.model.repositories.HistoryRepository;
import com.example.ProjectPolovinkin.model.repositories.UserBookRepository;
import com.example.ProjectPolovinkin.model.repositories.UserRepository;
import com.example.ProjectPolovinkin.helpers.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBookRepository userBookRepository;

    @Autowired
    HistoryRepository historyRepository;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String name) {

        try {
            List<Book> books = new ArrayList<Book>();
            bookRepository.findAll().forEach(books::add);
            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBooksById(@PathVariable("id") long id) {
        Optional<Book> bookData = bookRepository.findById(id);
        Calendar cal = Calendar.getInstance();
        List<UserBook> userBooks = new ArrayList<UserBook>();
        userBookRepository.findAll().forEach(userBooks::add);
        for (UserBook tmp: userBooks) {
            if (tmp.getComebackDate().before(cal.getTime())) {
                tmp.setCredit(true);
                tmp.getUser().setCountCredits(tmp.getUser().getCountCredits() + 1);
                userBookRepository.save(tmp);
            }
        }
        if (bookData.isPresent()) {
            return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createTutorial(@RequestBody Book book) {
        try {
            Book newBook = bookRepository
                    .save(new Book(book.getName(),book.getAuthor(),book.getCount(),book.getCount(),0,book.getDiscription(),book.getGenre(),book.getRating()));
            if (book.getRating() > 5) {
                return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
            }
            return new ResponseEntity<>(newBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            Optional<UserBook> us = userBookRepository.findByBookId(id);
            if(us.isPresent()) {
                Optional<Book> bookData = bookRepository.findById(id);
                Optional<User> userData = userRepository.findById(us.get().getUser().getId());
                Book newBook = bookData.get();
                User newUser = userData.get();
                newBook.setAvailableQuantity(newBook.getAvailableQuantity() + 1);
                newUser.setCountBooks(newUser.getCountBooks() - 1);
                newUser.removeBook(newBook);
                bookRepository.save(newBook);
                userRepository.save(newUser);
            }
            bookRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateTutorial(@PathVariable("id") long id, @RequestBody Book book) {
        Optional<Book> bookData = bookRepository.findById(id);

        if (bookData.isPresent()) {
            if (book.getRating() > 5) {
                return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
            }
            if (book.getAvailableQuantity() > book.getCount()) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Available quantity must be < count"));
            }
            Book newBook = bookData.get();
            newBook.setName(book.getName());
            newBook.setAuthor(book.getAuthor());
            newBook.setCount(book.getCount());
            newBook.setAvailableQuantity(book.getAvailableQuantity());
            newBook.setDiscription(book.getDiscription());
            newBook.setGenre(book.getGenre());
            newBook.setRating(book.getRating());
            return new ResponseEntity<>(bookRepository.save(newBook), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/books/take/{id}")
    public ResponseEntity<?> takeBook(@PathVariable("id") long id, @RequestBody TakeBookReq takeBookReq) {
        Optional<Book> bookData = bookRepository.findById(id);
        Optional<User> userData = userRepository.findById(takeBookReq.getUserInfo());
        Book newBook = bookData.get();
        User newUser = userData.get();
        if (newBook.getAvailableQuantity() > 0 && takeBookReq.getDays() > 0 && takeBookReq.getDays() < 100) {
            newBook.setAvailableQuantity(newBook.getAvailableQuantity() - 1);
            newUser.setCountBooks(newUser.getCountBooks() + 1);
            newUser.setCountTaken(newUser.getCountTaken() + 1);
            newBook.setCountTaken(newBook.getCountTaken() + 1);
            Set<Book> userBooks= newUser.getBooks();
            userBooks.add(newBook);
            newUser.setBooks(userBooks);
            bookRepository.save(newBook);
            userRepository.save(newUser);
            Long userBookId = userBookRepository.get();
            Optional<UserBook> userBookData = userBookRepository.findById(userBookId);
            UserBook newUserBook = userBookData.get();
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, takeBookReq.getDays());
            Calendar cal2 = Calendar.getInstance();
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = LocalDate.now().plusDays(takeBookReq.getDays());

            Period period = Period.between(startDate, endDate);

            newUserBook.setComebackDate(cal.getTime());
            newUserBook.setCredit(false);
            userBookRepository.save(newUserBook);
            History history = new History(newUser,newBook,cal.getTime(),Calendar.getInstance().getTime());
            historyRepository.save(history);
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/books/back/{id}")
    public ResponseEntity<?> backBook(@PathVariable("id") long id,@RequestBody Long userid) {

        Optional<Book> bookData = bookRepository.findById(id);
        Optional<User> userData = userRepository.findById(userid);
        Book newBook = bookData.get();
        User newUser = userData.get();
        List <History> historyList = new ArrayList<>();
        historyRepository.findByBookIdAndUserIdOrderByIdDesc(newBook,newUser).forEach(historyList::add);
        historyList.get(0).setComebackDateTrue(Calendar.getInstance().getTime());
        newBook.setAvailableQuantity(newBook.getAvailableQuantity() + 1);
        newUser.setCountBooks(newUser.getCountBooks() - 1);
        newUser.removeBook(newBook);
        historyRepository.save(historyList.get(0));
        bookRepository.save(newBook);
        userRepository.save(newUser);
        return ResponseEntity.ok(new MessageResponse("Successfully!"));
    }
    @GetMapping("/books/popular")
    public ResponseEntity<List<PopularBook>> getPopularBooks(@RequestParam(required = false) String name) {
        try {
            List<Long> b = new ArrayList<Long>();
            List<Integer> c = new ArrayList<Integer>();
            historyRepository.findPopular().forEach(b::add);
            historyRepository.findCount().forEach(c::add);
            List<Book> books = new ArrayList<Book>();
            List<PopularBook> popularBooks = new ArrayList<PopularBook>();
            for (Integer i = 0; i < b.size();++i) {
                Optional<Book> bookData = bookRepository.findById(b.get(i));
                PopularBook tmp = new PopularBook(b.get(i),bookData.get().getName(),bookData.get().getAuthor(),c.get(i));
                popularBooks.add(tmp);
            }
            if (popularBooks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(popularBooks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
