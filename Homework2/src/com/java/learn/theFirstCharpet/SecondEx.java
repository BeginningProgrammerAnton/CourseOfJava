package com.java.learn.theFirstCharpet;

import java.util.Scanner;

public class SecondEx {
    Scanner sc = new Scanner(System.in);
    int angle = sc.nextInt();
    public void getAsnPerent() {
        if (angle > 0) {
            System.out.println(angle % 360);
        } else {
            // - 5, - 365, - 500
            System.out.println(360 - Math.abs(angle) % 360);
        }
    }
    public void getAsnFM() {
        if (angle > 0) {
            System.out.println(Math.floorMod(angle,360));
        } else {
            // - 5, - 365, - 500
            System.out.println(360 - Math.floorMod(Math.abs(angle), 360));
        }
    }
}
