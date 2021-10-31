package com.howework.first.second;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coontainer that = (Coontainer) o;
        return x1 == that.x1 && y1 == that.y1 && x2 == that.x2 && y2 == that.y2;
    }

    @Override
    public int hashCode() {

        int result = 17;

        result = 31 * result + x1;
        result = 31 * result + x2;
        result = 31 * result + y1;
        result = 31 * result + y2;

        return result;
    }

    public boolean collides (Ball ball) {
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
