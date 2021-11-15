package com.java.learn.theFirstCharpet;

import java.math.BigInteger;

public class SixthEx {
    public void factorial(int number) {
        if (number == 0 || number == 1) {
            System.out.println(1);
        } else if (number == 2) {
            System.out.println(2);
        } else {
            String str = String.valueOf(number);
            BigInteger newNum = new BigInteger(str);
            newNum = newNum.add(BigInteger.ONE);
            BigInteger i = new BigInteger("3");
            BigInteger myNum = new BigInteger("2");
            do {
                myNum = myNum.multiply(i);
                i = i.add(BigInteger.ONE);
            }
            while (!(i.equals(newNum)));
            System.out.println(myNum);
        }
    }
}
