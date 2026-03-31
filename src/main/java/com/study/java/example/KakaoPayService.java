package com.study.java.example;

/**
 * 단일 상속:
 * - extends AbstractPaymentService 하나만 가능
 *
 * 다중 인터페이스 구현:
 * - implements Refundable 가능
 */
public class KakaoPayService extends AbstractPaymentService implements Refundable {

    public KakaoPayService(NotificationSender notificationSender) {
        super("KakaoPay", notificationSender);
    }

    @Override
    public void pay(int amount) {
        validateAmount(amount); // 부모 공통 로직 사용
        log(getServiceName() + " 결제 요청");
        System.out.println("카카오페이로 " + amount + "원 결제합니다.");
        notifyUser("카카오페이 결제가 완료되었습니다.");
    }

    @Override
    public void refund(int amount) {
        validateAmount(amount);
        log(getServiceName() + " 환불 요청");
        System.out.println("카카오페이로 " + amount + "원 환불합니다.");
        notifyUser("카카오페이 환불이 완료되었습니다.");
    }

    @Override
    protected String getPaymentType() {
        return "KAKAO";
    }
}