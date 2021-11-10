package com.java.learn.theSecondCharpet;

public class Car {
    private double x;
    private final double expenditure;
    private double petrol;
    private static final double max_liters = 100;

    public Car(double expenditure, double petrol) {
        this.expenditure = expenditure;
        this.petrol = petrol;
    }

    public Car() {
        this.expenditure = 0.1;
        this.petrol = 0;
    }

    public void toRefuel(double sum) {
        System.out.println("In tank " + this.petrol + "liters");
        System.out.println("You can refuel " + (max_liters - this.petrol) + "liters");
        if (this.petrol + sum > max_liters) {
            System.out.println("You can refuel < than " + (max_liters - this.petrol) + max_liters);
            System.out.println("Car is not refuel");
        } else {
            this.petrol += sum;
            System.out.println("Now you have " + this.petrol + "liters" + " and you can refuel " + (max_liters - petrol) + " liters");
        }
    }


    public void move(double get_x) {
        System.out.println("We start at " + x +" kilometers and have " + petrol + "liters of petrol");
        double different = Math.abs(get_x - x);
        double new_point = x + get_x;
        if (petrol - expenditure < 0) {
            System.out.println("You don't have petrol ");
        }
        while (Double.compare(x,new_point) != 0) {
            if ((petrol - expenditure) > 0) {
                x += 1;
                petrol -= expenditure;
                continue;
            }
            System.out.println("Petrol is ending");
            System.out.println("Now we at " + x + " kilometers");
            break;
        }
        System.out.println("Now we at " + x + " kilometers" + " and have " + petrol + "litters");
    }

    public double getX() {
        return x;
    }

    public double getPetrol() {
        return petrol;
    }
}
