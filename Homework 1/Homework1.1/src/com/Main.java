package com;

import com.my_company.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Authors a1 = new Authors();
        Authors a2 = new Authors();
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a1.equals(a2));
        Authors[] all = {a1,a2};

        Book b1 = new Book("1",12,2,all);
        Book b2 = new Book("1",12,2,all);
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b1.equals(b2));

        Circle c1 = new Circle();
        Circle c2 = new Circle();
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2));

        Employee e1 = new Employee(1,"a","b",10);
        Employee e2 = new Employee(1,"a","b",10);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(e1.equals(e2));

        MyPoint mp1 = new MyPoint();
        MyPoint mp2 = new MyPoint();
        System.out.println(mp1.hashCode());
        System.out.println(mp2.hashCode());
        System.out.println(mp1.equals(mp2));

        MyTriangle tr1 = new MyTriangle(1,2,3,4,5,6);
        MyTriangle tr2 = new MyTriangle(1,2,3,4,5,6);
        System.out.println(tr1.hashCode());
        System.out.println(tr2.hashCode());
        System.out.println(tr1.equals(tr2));

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        System.out.println(r1.hashCode());
        System.out.println(r2.hashCode());
        System.out.println(r1.equals(r2));


    }


}
