package com;

import com.my_company.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(5,5);
        MyPoint p2 = new MyPoint(0,0);
        MyPoint p3 = new MyPoint(15,0);
//        System.out.println(p.distance());
//        System.out.println(p.distance(2,2));
//        System.out.println(p.distance(p2));
//        System.out.println(p.toString());
        MyTriangle tri = new MyTriangle(p1,p2,p3);
        System.out.println(tri);
        System.out.println(p2.distance(p3));
        System.out.println(p3.distance(p1));
        System.out.println(tri.getType());
    }


}
