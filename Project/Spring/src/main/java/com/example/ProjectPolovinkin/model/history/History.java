package com.example.ProjectPolovinkin.model.history;

import com.example.ProjectPolovinkin.model.Book;
import com.example.ProjectPolovinkin.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_comeback")
    private Date dateComeback;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_take")
    private Date dateTake;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_comeback_true")
    private Date comebackDateTrue;

    public Date getDateComeback() {
        return dateComeback;
    }

    public void setDateComeback(Date dateComeback) {
        this.dateComeback = dateComeback;
    }

    public Date getDateTake() {
        return dateTake;
    }

    public void setDateTake(Date dateTake) {
        this.dateTake = dateTake;
    }

    public Date getComebackDateTrue() {
        return comebackDateTrue;
    }

    public void setComebackDateTrue(Date comebackDateTrue) {
        this.comebackDateTrue = comebackDateTrue;
    }

    public History(User userId, Book bookId, Date dateComeback, Date dateTake) {
        this.userId = userId;
        this.bookId = bookId;
        this.dateComeback = dateComeback;
        this.dateTake = dateTake;
    }

    public History() {
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", dateComeback=" + dateComeback +
                ", dateTake=" + dateTake +
                ", comebackDateTrue=" + comebackDateTrue +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

}
