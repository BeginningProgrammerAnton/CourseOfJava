package com.java.learn.theSecondCharpet;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void translate(double get_x,double get_y) {
        this.x += get_x;
        this.y += get_y;
    }

    public void scale (double tmp) {
        this.x *= tmp;
        this.y *= tmp;
    }

    @Override
    public String toString() {
        return "Point(" +
                 x +
                "," + y +
                ')';
    }
}
