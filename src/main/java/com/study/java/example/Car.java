package com.study.java.example;

public class Car {

    private String brand;
    private Engine engine; // 포함관계

    /**
     * static final:
     * - 클래스 상수
     * - 객체마다 아니라 공용
     */
    public static final int MAX_SPEED = 300;

    public Car(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }

    public void drive() {
        System.out.println(brand + " 자동차가 주행을 시작합니다.");
        engine.start();
    }

    /**
     * 정적 중첩 클래스(static nested class)
     * 바깥 객체 없이도 생성 가능
     */
    public static class CarUtils {
        public static void printMaxSpeed() {
            System.out.println("최대 속도 제한: " + MAX_SPEED);
        }
    }

    /**
     * 내부 클래스(inner class)
     * 바깥 Car 객체에 소속됨
     */
    public class Driver {
        public void introduce() {
            System.out.println("저는 " + brand + "의 운전자입니다.");
        }
    }
}