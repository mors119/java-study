package com.study.java.chapter;

import com.study.java.example.OrderStatus;

public class Chapter17Enum {
    public static void main(String[] args) {

        OrderStatus status = OrderStatus.READY;

        System.out.println(status);

        switch (status) {
            case READY -> System.out.println("준비");
            case SHIPPED -> System.out.println("배송 중");
            case DELIVERED -> System.out.println("완료");
        }
    }
}

