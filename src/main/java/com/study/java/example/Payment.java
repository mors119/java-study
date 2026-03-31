package com.study.java.example;

/**
 * 결제 기능 규약
 * implement 하는 클래스는 반드시 pay()를 구현해야 한다.
 */
public interface Payment {

    /**
     * 인터페이스 상수
     * public static final 이 자동으로 붙는다.
     */
    String CURRENCY = "KRW";

    /**
     * 추상 메서드
     * public abstract 가 자동으로 붙는다.
     *
     * @param amount 결제 금액
     */
    void pay(int amount);

    /**
     * default 메서드
     * 구현체가 공통으로 쓸 수 있는 기본 동작
     */
    default void printCurrency() {
        System.out.println("결제 통화: " + CURRENCY);
    }

    /**
     * static 메서드
     * 인터페이스 이름으로 직접 호출
     */
    static void printSystemInfo() {
        System.out.println("Payment 시스템이 실행 중입니다.");
    }
}