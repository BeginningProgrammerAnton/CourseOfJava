package com.howework.first.second;

public class Coontainer {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Coontainer(int x1, int y1, int width,int heigth) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + heigth;
        this.y2 = y1 + width;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return y2;
    }

    public int getHeigth() {
        return x2;
    }
    public boolean collides ( Ball ball) {
        if ( x1 <= ball.getX() + ball.getRadius() && ball.getX() + ball.getRadius() <= x2 && y1 <= ball.getY() + ball.getRadius() && ball.getY() + ball.getRadius() <= y2) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Coontainer[" +
                "(" + x1 +
                "," + y1 +
                "),(" + x2 +
                "," + y2 +
                ")]";
    }
}
