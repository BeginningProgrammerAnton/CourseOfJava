package com.example.ProjectPolovinkin.model.repositories;

import com.example.ProjectPolovinkin.model.User;
import com.example.ProjectPolovinkin.model.UserBook;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserBookRepository extends JpaRepository<UserBook,Long> {

    @Query(value ="SELECT id FROM user_book ORDER BY id DESC LIMIT 1",nativeQuery = true)
    Long get();
    void deleteByBookId(Long id);
    Optional<UserBook> findByBookId(Long id);
}
