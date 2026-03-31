package com.study.java.example;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void speak() {
        System.out.println(name + "가 야옹 웁니다.");
    }

    public void climb() {
        System.out.println(name + "가 높은 곳에 올라갑니다.");
    }
}