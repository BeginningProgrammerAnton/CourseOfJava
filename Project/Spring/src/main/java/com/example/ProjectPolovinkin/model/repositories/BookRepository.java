package com.example.ProjectPolovinkin.model.repositories;

import com.example.ProjectPolovinkin.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long>{
    List<Book> findAllByOrderByCountTakenDesc();
    List<Book> findAllByOrderByName();
    List<Book> findAllByOrderByAuthor();
    List<Book> findAllByOrderByRatingDesc();
    List<Book> findAllByOrderByGenreDesc();
}
