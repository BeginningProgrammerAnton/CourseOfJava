package com.example.ProjectPolovinkin.model.history;

public class PopularBook {
    private Long id;
    private String name;
    private String author;
    private Integer countTaken;

    public PopularBook(Long id, String name, String author, Integer countTaken) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.countTaken = countTaken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getCountTaken() {
        return countTaken;
    }

    public void setCountTaken(Integer countTaken) {
        this.countTaken = countTaken;
    }
}
