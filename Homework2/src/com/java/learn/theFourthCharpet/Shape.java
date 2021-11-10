package com.java.learn.theFourthCharpet;

public abstract class Shape implements Cloneable {
    Point point = new Point();

    abstract public Point getCenter();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Shape)super.clone();
    }
}
