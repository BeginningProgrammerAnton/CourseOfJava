package com.java.learn.theFirstCharpet;

import java.util.Scanner;

public class ThirdEx {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    public void getMax() {
        if (a >= b && a >= c) {
            System.out.println(a);
        } else if (b >= a && b >= c) {
            System.out.println(b);
        } else {
            System.out.println(c);
        }
    }
    public void getMaxFunc(){
        int new_max = Math.max(a,b);
        System.out.println(Math.max(new_max,c));
    }
}
