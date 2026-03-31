package com.study.java.example;

/**
 * 알림 전송 인터페이스 구현체
 */
public class SimpleEmailSender implements NotificationSender {

    @Override
    public void send(String message) {
        System.out.println("[EMAIL] " + message);
    }
}