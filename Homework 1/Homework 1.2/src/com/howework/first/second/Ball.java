package com.howework.first.second;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        double v = (double)direction / (double)speed;
        this.radius = radius;
        this.xDelta =(float)(speed * Math.cos(v));
        this.yDelta = (float)(-1 * speed * Math.sin(v));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        this.x += this.xDelta;
        this.y += this.yDelta;
    }
    public void reflectHorizontal() {
        this.xDelta *= -1;
    }

    public void reflectVertical() {
        this.yDelta *= -1;
    }

    @Override
    public String toString() {
        return "Ball[(" + x + "," + y + "),speed=(D" + xDelta + ",D" + yDelta + ")]" ;
    }
}
