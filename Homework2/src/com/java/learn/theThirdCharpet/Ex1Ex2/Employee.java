package com.java.learn.theThirdCharpet.Ex1Ex2;

public class Employee implements Measurable{
    private double salary;
    private String name;

    public Employee(double salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public static double average (Measurable[] object) {
        double res = 0;
        for (int i = 0; i < object.length; i++) {
            res += object[i].getMeasure();
        }
        return res / object.length;
    }

    public static Measurable largest(Measurable[] object) {
        Measurable max = object[0];
        for (int i = 1; i < object.length; i++) {
            if (object[i].getMeasure() > max.getMeasure()) {
                max = object[i];
            }
        }
        return max;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
