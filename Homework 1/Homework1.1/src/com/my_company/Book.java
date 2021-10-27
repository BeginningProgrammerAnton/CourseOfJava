package com.my_company;

import java.util.Arrays;
import java.util.Vector;

public class Book {

    private String name;
    private double price;
    private int qty = 0;
    Authors[] authors = new Authors[10];

    public Book(String name, double price, int qty, Authors[] authors) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.authors = authors;
    }

    public Book(String name, double price, Authors[] authors) {
        this.name = name;
        this.price = price;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public Authors[] getAuthors() {
        return authors;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book[" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", authors=" + Arrays.toString(authors) +
                ']';
    }

    public String getAuthorsNames() {
        String[] all = new String[authors.length];
        for (int i = 0; i < authors.length; i++) {
            all[i] = authors[i].name;
        }
        return(Arrays.toString(all));
    }
}
