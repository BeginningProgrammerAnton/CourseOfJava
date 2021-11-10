package com.java.learn;


import com.java.learn.theFourthCharpet.*;

public class Main {

    public static void main(String[] args) {
        Point point = new Point(1,2);
        Circle circle = new Circle(10,point);
        System.out.println(circle.getCenter());
        Point point1 = new Point(0,0);
        Rectangle rectangle = new Rectangle(point1,10,10);
        System.out.println(rectangle.getCenter());
        Line line = new Line(point1,point);
        System.out.println(line.getCenter());
    }

}
