package com.study.java.example;

/**
 * 네이버페이 구현체
 */
public class NaverPayService extends AbstractPaymentService implements Refundable {

    public NaverPayService(NotificationSender notificationSender) {
        super("NaverPay", notificationSender);
    }

    @Override
    public void pay(int amount) {
        validateAmount(amount);
        log(getServiceName() + " 결제 요청");
        System.out.println("네이버페이로 " + amount + "원 결제합니다.");
        notifyUser("네이버페이 결제가 완료되었습니다.");
    }

    @Override
    public void refund(int amount) {
        validateAmount(amount);
        log(getServiceName() + " 환불 요청");
        System.out.println("네이버페이로 " + amount + "원 환불합니다.");
        notifyUser("네이버페이 환불이 완료되었습니다.");
    }

    @Override
    protected String getPaymentType() {
        return "NAVER";
    }
}