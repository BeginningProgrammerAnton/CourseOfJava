package com.java.learn.theFirstCharpet;

import java.math.BigInteger;

public class SixthEx {
    public void factorial(int number) {
        String str = String.valueOf(number);
        BigInteger new_num = new BigInteger(str);
        new_num = new_num.add(BigInteger.ONE);
        BigInteger i = new BigInteger("3");
        BigInteger my_num = new BigInteger("2");
        do {
            my_num = my_num.multiply(i);
            i = i.add(BigInteger.ONE);
        }
        while (!(i.equals(new_num)));
        System.out.println(my_num);
    }
}
