package com.java.learn.theFourthCharpet;

public class Circle extends Shape implements  Cloneable {

    private double radius;

    public Circle(double radius, Point center) {
        this.radius = radius;
        super.point = center;
    }

    @Override
    public Point getCenter() {
        return point;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Circle)super.clone();
    }
}
