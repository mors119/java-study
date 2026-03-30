package com.study.java.chapter;

class Car {

    private String brand;
    private int speed;

    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void accelerate() {
        speed += 10;
        System.out.println(brand + " 속도: " + speed);
    }

    public void brake() {
        speed -= 10;
        System.out.println(brand + " 속도: " + speed);
    }
}

public class Chapter06Class {

    public static void main(String[] args) {

        Car car = new Car("BMW", 200);

        car.accelerate();
        car.brake();
    }
}