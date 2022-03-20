package com.example.ProjectPolovinkin.controllers;

import com.example.ProjectPolovinkin.model.Book;
import com.example.ProjectPolovinkin.model.Comment;
import com.example.ProjectPolovinkin.model.repositories.BookRepository;
import com.example.ProjectPolovinkin.model.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/comments")
    public ResponseEntity<Comment> createTutorial(@RequestBody Comment comment) {
        Optional<Book> bookData = bookRepository.findById(comment.getBook().getId());
        bookRepository.save(bookData.get());
        Comment _comment = commentRepository.save(new Comment(comment.getText(),comment.getBook(),comment.getAuthor()));
            return new ResponseEntity<>(_comment, HttpStatus.CREATED);
    }
    @GetMapping("/comments/{id}")
    public ResponseEntity<List<Comment>> getBooksById(@PathVariable("id") long id) {

        Optional<Book> bookData = bookRepository.findById(id);
        List<Comment> commentData = new ArrayList<>();
        commentData = commentRepository.findByBook(bookData.get());
            return new ResponseEntity<>(commentData, HttpStatus.OK);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment comment) {
        Optional<Comment> commentData = commentRepository.findById(id);
        if (commentData.isPresent()) {
            Comment _comment = commentData.get();
            _comment.setText(comment.getText());
            return new ResponseEntity<>(commentRepository.save(_comment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            commentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
