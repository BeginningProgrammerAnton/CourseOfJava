package com.example.ProjectPolovinkin.model.history;

import com.example.ProjectPolovinkin.model.Book;

import java.util.Set;

public class UsersCredits {
    private Long id;
    private String username;
    private Integer countCredits;
    private Set<Book> creditBooks;

    public UsersCredits(Long id, String username, Integer countCredits, Set<Book> creditBooks) {
        this.id = id;
        this.username = username;
        this.countCredits = countCredits;
        this.creditBooks = creditBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCountCredits() {
        return countCredits;
    }

    public void setCountCredits(Integer countCredits) {
        this.countCredits = countCredits;
    }

    public Set<Book> getCreditBooks() {
        return creditBooks;
    }

    public void setCreditBooks(Set<Book> creditBooks) {
        this.creditBooks = creditBooks;
    }
}
