package com.example.ProjectPolovinkin.model.repositories;

import com.example.ProjectPolovinkin.model.Book;
import com.example.ProjectPolovinkin.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByBook(Book book);
}
