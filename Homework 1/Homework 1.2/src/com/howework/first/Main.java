package com.howework.first;

import com.howework.first.second.Ball;
import com.howework.first.second.Coontainer;
import com.howework.first.second.MyComplex;
import com.howework.first.second.MyPolynomial;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class Main {

    public static void main(String[] args) {
        Ball ball = new Ball(5,5,2,1,1);
        Coontainer con = new Coontainer(0,0,10,10);
        System.out.println(ball);
        System.out.println(con);
        ball.move();
        System.out.println(ball);
        System.out.println(con.collides(ball));
        ball.move();
        System.out.println(ball);
        System.out.println(con.collides(ball));
        ball.move();
        System.out.println(ball);
        System.out.println(con.collides(ball));
        ball.move();
        System.out.println(ball);
        System.out.println(con.collides(ball));
        ball.move();
        System.out.println(ball);
        //Ball[(7.7015114,0.79264545),speed=(D0.5403023,D-0.84147096)]
        System.out.println(con.collides(ball)); // true
        ball.move();
        System.out.println(ball); //Ball[(8.241814,-0.048825502),speed=(D0.5403023,D-0.84147096)]
        System.out.println(con.collides(ball)); // false
    }
}
