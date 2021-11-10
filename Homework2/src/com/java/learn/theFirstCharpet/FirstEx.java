package com.java.learn.theFirstCharpet;

import java.util.Scanner;

public class FirstEx {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    public void getAnswear() {
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toOctalString(a));
        System.out.println(Integer.toHexString(a));
        float new_num = a;
        System.out.println(Float.toHexString(new_num));
    }
}
