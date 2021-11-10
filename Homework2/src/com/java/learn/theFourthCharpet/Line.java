package com.java.learn.theFourthCharpet;

public class Line extends Shape implements Cloneable{
    Point from;
    Point to;

    public Line(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Point getCenter() {
        Point center = new Point();
        super.point.moveBy((from.getX() - to.getX()) / 2,(from.getY() - to.getY()) / 2);
        return super.point;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Line)super.clone();
    }
}
