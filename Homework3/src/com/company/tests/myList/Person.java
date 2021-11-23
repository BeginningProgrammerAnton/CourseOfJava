package com.company.tests.myList;

public class Person {
    private String firstName;
    private int age;
    private String lastName;
    private String sity;

    public Person(String firstName, int age, String lastName, String sity) {
        this.firstName = firstName;
        this.age = age;
        this.lastName = lastName;
        this.sity = sity;
    }

    @Override
    public String toString() {
        return firstName  +
                " "+ age +
                " " + lastName  +
                " " + sity;
    }
}
