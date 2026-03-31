package com.study.java.example;

/**
 * 로그 출력 기능 규약
 */
public interface PaymentLogger {

    default void log(String message) {
        System.out.println("[LOG] " + message);
    }
}