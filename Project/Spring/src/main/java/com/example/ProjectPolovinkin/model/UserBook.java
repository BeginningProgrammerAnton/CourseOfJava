package com.example.ProjectPolovinkin.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_book")
public class UserBook {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Override
    public String toString() {
        return "UserBook{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", comebackDate=" + comebackDate +
                '}';
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data_comeback")
    private Date comebackDate;

    @Column(name = "credit")
    private Boolean credit;

    public Date getComebackDate() {
        return comebackDate;
    }

    public void setComebackDate(Date comebackDate) {
        this.comebackDate = comebackDate;
    }

    public Boolean isCredit() {
        return credit;
    }

    public void setCredit(Boolean credit) {
        this.credit = credit;
    }

    public UserBook(Long id, User user, Book book, Date comebackDate, Boolean credit) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.comebackDate = comebackDate;
        this.credit = credit;
    }

    public UserBook() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
