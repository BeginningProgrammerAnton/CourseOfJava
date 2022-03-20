package com.example.ProjectPolovinkin.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "author",nullable = false)
    private String author;

    @Column(name = "count",nullable = false)
    private Integer count;

    @Column(name = "availablequantity",nullable = false)
    private Integer availableQuantity;

    @OneToMany(mappedBy = "book", orphanRemoval = true)
    private List<Comment> comments;

    @Column(name = "countTaken")
    private Integer countTaken;

    @Column(name = "discription")
    private String discription;

    @Column(name = "genre")
    private Genre genre;

    @Column(name = "rating")
    private Integer rating;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getCountTaken() {
        return countTaken;
    }

    public void setCountTaken(Integer countTaken) {
        this.countTaken = countTaken;
    }

    public String getDiscription() {
        return discription;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", count=" + count +
                ", availableQuantity=" + availableQuantity +
                ", comments=" + comments +
                ", countTaken=" + countTaken +
                ", discription='" + discription + '\'' +
                ", genre=" + genre +
                '}';
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Book(String name, String author, Integer count, Integer availableQuantity, Integer countTaken, String discription, Genre genre, Integer rating) {
        this.name = name;
        this.author = author;
        this.count = count;
        this.availableQuantity = availableQuantity;
        this.countTaken = countTaken;
        this.discription = discription;
        this.genre = genre;
        this.rating = rating;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCount() {
        return count;
    }

    public long getId() {
        return id;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

}
