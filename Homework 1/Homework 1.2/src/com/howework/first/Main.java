package com.howework.first;

import com.howework.first.second.Ball;
import com.howework.first.second.Coontainer;
import com.howework.first.second.MyComplex;
import com.howework.first.second.MyPolynomial;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class Main {

    public static void main(String[] args) {

        MyPolynomial mp1 = new MyPolynomial(1,2,3);
        MyPolynomial mp2 = new MyPolynomial(1,2,3);
        System.out.println(mp1.hashCode());
        System.out.println(mp2.hashCode());
        System.out.println(mp1.equals(mp2));
        Coontainer con1 = new Coontainer(1,2,3,4);
        Coontainer con2 = new Coontainer(1,2,3,4);
        System.out.println(con1.hashCode());
        System.out.println(con2.hashCode());
        System.out.println(con1.equals(con2));
        MyComplex c1 = new MyComplex(10.1,25);
        MyComplex c2 = new MyComplex(10.1,25);
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        Ball b1 = new Ball(1,2,3,4,5);
        Ball b2 = new Ball(1,2,3,4,5);
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b1.equals(b2));


    }
}
