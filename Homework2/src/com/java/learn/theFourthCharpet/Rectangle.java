package com.java.learn.theFourthCharpet;

public class Rectangle extends Shape implements Cloneable{
    private double width;
    private double heigth;

    public Rectangle(Point topLeft, double width, double heigth) {
        super.point = topLeft;
        this.width = width;
        this.heigth = heigth;
    }

    @Override
    public Point getCenter() {
        super.point.moveBy(heigth/2,-(width/2));
        return point;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Rectangle)super.clone();
    }
}
