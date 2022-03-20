package com.example.ProjectPolovinkin.controllers;

import com.example.ProjectPolovinkin.model.Book;
import com.example.ProjectPolovinkin.model.User;
import com.example.ProjectPolovinkin.model.UserBook;
import com.example.ProjectPolovinkin.model.repositories.BookRepository;
import com.example.ProjectPolovinkin.model.repositories.UserBookRepository;
import com.example.ProjectPolovinkin.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserBookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBookRepository userBookRepository;

    @GetMapping("/userBook")
    public ResponseEntity<List<UserBook>> getAllUserBooks(@RequestParam(required = false) String name) {
        try {
            Calendar cal = Calendar.getInstance();
            List<UserBook> userBooks = new ArrayList<UserBook>();
            userBookRepository.findAll().forEach(userBooks::add);
            for (UserBook tmp: userBooks) {
                if (tmp.getComebackDate().before(cal.getTime())) {
                    tmp.setCredit(true);
                    tmp.getUser().setCountCredits(tmp.getUser().getCountBooks() + 1);
                    userBookRepository.save(tmp);
                }
            }
            if (userBooks.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(userBooks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/userBookReturn/{id}")
    public ResponseEntity<List<Book>> getReturnedUserBooks(@PathVariable("id") long id) {
        List<Book> booksReturned = new ArrayList<>();
        try {
            List<UserBook> userBooks = new ArrayList<UserBook>();
            userBookRepository.findAll().forEach(userBooks::add);
            for (UserBook tmp: userBooks) {
                if (tmp.getUser().getId() == id && tmp.isCredit()) {
                    booksReturned.add(tmp.getBook());
                }
            }
            if (booksReturned.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(booksReturned, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
