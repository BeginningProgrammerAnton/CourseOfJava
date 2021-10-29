package com.howework.first.second;

import java.util.Objects;

public class MyComplex {

    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.imag = imag;
        this.real = real;
    }

    @Override
    public String toString() {
        if ( this.imag < 0 ) {
            return "(real+imagi)" +
                    ",e.g."+
                    "(" +real + "+" +"("+ imag +")"+ "i"+
                    ')';
        } else {
            return "(real+imagi)" +
                    ",e.g."+
                    "(" +real + "+" + imag + "i"+
                    ')';
        }

    }

    boolean isReal() {
        if (real > 0.0) {
            return true;
        } else {
            return false;
        }
    }

    boolean isImaginary() {
        if (imag > 0.0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean equals(double real,double imag) {
        if (Math.abs(imag - real) < 0.000001 ) return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyComplex)) return false;
        MyComplex myComplex = (MyComplex) o;
        return this.real == myComplex.real && this.imag == myComplex.imag;
    }

    @Override
    public int hashCode() {
        int result = 18;
        result = 31 * result + (int)Double.doubleToLongBits(real);
        result = 31 * result + (int)Double.doubleToLongBits(imag);
        return result;
    }

    public double magnitude() {
        return Math.abs(Math.sqrt(this.real * this.real + this.imag * this.imag));
    }

    public double argument() {
        return Math.atan(this.imag / this.real);
    }

    public MyComplex add (MyComplex rigth) {
        this.real += rigth.real;
        this.imag += rigth.imag;
        return this;
    }
    public MyComplex addNew (MyComplex rigth) {
        MyComplex new_complex = new MyComplex(this.real + rigth.real,this.imag + rigth.imag);
        return new_complex;
    }

    public MyComplex subtract (MyComplex rigth) {
        this.real -= rigth.real;
        this.imag -= rigth.imag;
        return this;
    }

    public MyComplex subtractNew (MyComplex rigth) {
        MyComplex new_complex = new MyComplex(this.real - rigth.real,this.imag - rigth.imag);
        return new_complex;
    }

    public MyComplex multiply (MyComplex rigth) {
        this.real = (this.real * rigth.real - this.imag * rigth.imag);
        this.imag = (this.real * rigth.imag + this.imag * rigth.real);
        return this;
    }

    public MyComplex divide (MyComplex rigth) {
        this.real = (this.real * rigth.real + this.imag * rigth.imag) / (Math.pow(rigth.real,2) + Math.pow(rigth.imag,2));
        this.imag /= rigth.imag;
        return this;
    }

    public MyComplex conjugate() {
        this.imag *= -1;
        return this;
    }

}
