package com.example.ProjectPolovinkin.controllers;


import com.example.ProjectPolovinkin.model.Book;
import com.example.ProjectPolovinkin.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class SortController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books/sortName")
    public ResponseEntity<List<Book>> getSortName(@RequestParam(required = false) String name) {
        try {
            List<Book> books = new ArrayList<Book>();
            bookRepository.findAllByOrderByName().forEach(books::add);
            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/sortAuthor")
    public ResponseEntity<List<Book>> getSortAuthor(@RequestParam(required = false) String name) {
        try {
            List<Book> books = new ArrayList<Book>();
            bookRepository.findAllByOrderByAuthor().forEach(books::add);
            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/sortGenre")
    public ResponseEntity<List<Book>> getSortGenre(@RequestParam(required = false) String name) {
        try {
            List<Book> books = new ArrayList<Book>();
            bookRepository.findAllByOrderByGenreDesc().forEach(books::add);
            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/books/sortRating")
    public ResponseEntity<List<Book>> getSortRating(@RequestParam(required = false) String name) {
        try {
            List<Book> books = new ArrayList<Book>();
            bookRepository.findAllByOrderByRatingDesc().forEach(books::add);
            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
