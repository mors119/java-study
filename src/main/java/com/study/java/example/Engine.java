package com.study.java.example;

/**
 * Engine은 Car의 부모가 아님
 * Car가 Engine을 "가진다"
 * -> 포함관계(has-a)
 */
public class Engine {

    private int horsePower;

    public Engine(int horsePower) {
        this.horsePower = horsePower;
    }

    public void start() {
        System.out.println("엔진이 시동됩니다. 출력: " + horsePower + "HP");
    }

    public int getHorsePower() {
        return horsePower;
    }
}