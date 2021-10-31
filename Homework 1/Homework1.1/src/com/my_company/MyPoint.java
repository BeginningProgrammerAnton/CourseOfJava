package com.my_company;

import java.util.Objects;

public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        int array[] = new int[]{x,y};
        return array;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyPoint)) return false;
        MyPoint mp = (MyPoint) o;
        return this.x == mp.x && this.y == mp.y;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "(" +
                 + x +
                ","  + y +
                ')';
    }
    public double distance(int x, int y) {
        double big_x = Math.pow((x - this.x),2);
        double big_y = Math.pow((y - this.y),2);
        return Math.abs(Math.sqrt(big_x + big_y));
    }

    public double distance(MyPoint point) {
        double big_x = Math.pow((point.x - this.x),2);
        double big_y = Math.pow((point.y - this.y),2);
        return Math.abs(Math.sqrt(big_x + big_y));
    }

    public double distance () {
        double big_x = Math.pow(this.x,2);
        double big_y = Math.pow(this.y,2);
        return Math.abs(Math.sqrt(big_x + big_y));
    }

}
