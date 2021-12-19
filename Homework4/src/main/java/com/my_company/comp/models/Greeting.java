package com.my_company.comp.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Greeting {

    @NotEmpty(message = "Name should not be empty")
    private String firstName;

    @NotEmpty(message = "Name should not be empty")
    private String lastName;

    @NotEmpty(message = "Name should not be empty")
    private String fatherName;

    @NotEmpty(message = "Email should not empty")
    @Email(message = "Incorrect email")
    private String email;

    @NotEmpty(message = "Work place should not be empty")
    private String workPlace;

    @Min(value = 0,message = "Age should be more that 0")
    private int age;

    @Min(value = 0,message = "Salary should be more that 0")
    private int salary;

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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public void write(final String s){
        String filePath = "src/main/java/res.txt";
        String text = s + "\n";
        try {
            Files.write(Paths.get(filePath), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
