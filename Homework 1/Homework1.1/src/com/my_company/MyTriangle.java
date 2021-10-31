package com.my_company;

import java.util.Objects;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;
    private final double epsilon = 0.000001;
        enum Type {Equilateral, Isosceles, Scalene};

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public MyTriangle(int x1, int y1,int x2, int y2, int x3, int y3) {
        MyPoint vv1 = new MyPoint(x1,y1);
        MyPoint vv2 = new MyPoint(x2,y2);
        MyPoint vv3 = new MyPoint(x3,y3);
        this.v1 = vv1;
        this.v2 = vv2;
        this.v3 = vv3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTriangle)) return false;
        MyTriangle mt = (MyTriangle) o;
        return this.v1.equals(mt.v1) && this.v2.equals(mt.v2) && this.v3.equals(mt.v3);

    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + v1.hashCode();
        result = 31 * result + v2.hashCode();
        result = 31 * result + v3.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "MyTriangle[" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                ']';
    }

    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }


    public String getType() {
        final double epsilon = 0.000001;
        if((Math.abs(v1.distance(v2) - v2.distance(v3)) <= epsilon) && (Math.abs(v2.distance(v3) - v3.distance(v1)) <= epsilon) && (Math.abs(v1.distance(v2) - v3.distance(v1)) <= epsilon)){
            return Type.Equilateral.name();
        }
        if((Math.abs(v1.distance(v2) - v2.distance(v3)) <= epsilon) || (Math.abs(v2.distance(v3) - v3.distance(v1)) <= epsilon) || (Math.abs(v1.distance(v2) - v3.distance(v1)) <= epsilon)){
            return Type.Isosceles.name();
        }
        return Type.Scalene.name();

    }
}
