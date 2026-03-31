package com.study.java.chapter;

import com.study.java.example.*;

public class Chapter09AbstractInterfacePolymorphism {

    public static void main(String[] args) {

        // 인터페이스 static 메서드 호출
        Payment.printSystemInfo();

        System.out.println();

        // 포함관계용 객체 생성
        NotificationSender sender = new SimpleEmailSender();

        // 다형성 1: 부모 타입(인터페이스)으로 구현체 참조
        Payment kakaoPayment = new KakaoPayService(sender);
        Payment naverPayment = new NaverPayService(sender);

        kakaoPayment.printCurrency();
        kakaoPayment.pay(10000);

        System.out.println();

        naverPayment.printCurrency();
        naverPayment.pay(20000);

        System.out.println();

        // 다형성 2: 부모 타입(추상 클래스)으로 구현체 참조
        AbstractPaymentService service = new KakaoPayService(sender);
        System.out.println("서비스 이름: " + service.getServiceName());
        System.out.println("서비스 타입: " + service.getClass().getSimpleName());

        System.out.println();

        // 다형성 3: 환불 인터페이스로 참조
        Refundable refundable = new NaverPayService(sender);
        refundable.refund(5000);

        System.out.println();

        // 다운캐스팅 예시
        if (kakaoPayment instanceof KakaoPayService) {
            KakaoPayService kakao = (KakaoPayService) kakaoPayment;
            kakao.refund(3000);
        }

        System.out.println();

        // 여러 구현체를 같은 타입으로 다루기
        Payment[] payments = {
                new KakaoPayService(sender),
                new NaverPayService(sender)
        };

        for (Payment payment : payments) {
            payment.pay(7000);
            System.out.println("---");
        }
    }
}