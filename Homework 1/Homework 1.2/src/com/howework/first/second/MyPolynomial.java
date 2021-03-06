package com.howework.first.second;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs_new) {
        coeffs = new double[coeffs_new.length];
        for (int i = 0; i < coeffs.length; i++) {
            this.coeffs[i] = coeffs_new[i];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(this.coeffs,that.coeffs);
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + Arrays.hashCode(coeffs);
        return result;
    }

    public int getDegree() {
        return coeffs.length;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < coeffs.length - 1; i++) {
            int tmp = coeffs.length - i - 1;
            str = str + coeffs[i] + "x^" + tmp + "+";
        }
        str = str + coeffs[coeffs.length -1];
        return str;
    }

    public double evaluate(double x) {
        double res = 0;
        for (int i = 0,j = coeffs.length - 1; i < coeffs.length; i++,j--) {
            res += Math.pow(x,j) * coeffs[i];
        }
        return res;
    }

    public MyPolynomial add (MyPolynomial right) {
        MyPolynomial new_p =(this.coeffs.length >= right.coeffs.length) ? new MyPolynomial(this.coeffs) : new MyPolynomial(right.coeffs);
        int my_max = Math.abs(this.coeffs.length - right.coeffs.length);
        for (int i = my_max,j = 0; i < Math.max(this.coeffs.length,right.coeffs.length); i++, j ++) {

            new_p.coeffs[i] += right.coeffs[j];
        }
        return new_p;
    }

    public MyPolynomial multiply (MyPolynomial right) {
        MyPolynomial new_p =(this.coeffs.length >= right.coeffs.length) ? new MyPolynomial(this.coeffs) : new MyPolynomial(right.coeffs);
        int my_max = Math.abs(this.coeffs.length - right.coeffs.length);
        for (int i = my_max,j = 0; i < Math.max(this.coeffs.length,right.coeffs.length); i++, j ++) {

            new_p.coeffs[i] *= right.coeffs[j];
        }
        return new_p;
    }
}
