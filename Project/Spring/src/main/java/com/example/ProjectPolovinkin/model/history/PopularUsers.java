package com.example.ProjectPolovinkin.model.history;

public class PopularUsers {
    private String username;
    private String firstName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCountTaken() {
        return countTaken;
    }

    public void setCountTaken(Integer countTaken) {
        this.countTaken = countTaken;
    }


    private String lastName;
    private Integer countTaken;
    private Long id;

    public PopularUsers(String username, String firstName, String lastName, Integer countTaken, Long id) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.countTaken = countTaken;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
