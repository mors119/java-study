package com.study.java.example;
/**
 * 결제 서비스 공통 부모
 *
 * abstract class:
 * - 객체를 직접 생성할 수 없음
 * - 자식 클래스가 상속받아 사용
 */
public abstract class AbstractPaymentService implements Payment, PaymentLogger {

    /**
     * 공통 상태
     * private: 외부 직접 접근 차단
     */
    private final String serviceName;

    /**
     * 포함관계(has-a)
     * 알림 전송기를 내부 필드로 가짐
     */
    private final NotificationSender notificationSender;

    /**
     * 생성자
     *
     * @param serviceName 서비스 이름
     * @param notificationSender 알림 발송기
     */
    public AbstractPaymentService(String serviceName, NotificationSender notificationSender) {
        this.serviceName = serviceName;
        this.notificationSender = notificationSender;
    }

    /**
     * 공통 구현 메서드
     * 자식이 그대로 사용할 수 있음
     */
    public void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("결제 금액은 0보다 커야 합니다.");
        }
    }

    /**
     * 공통 구현 메서드
     */
    public void notifyUser(String message) {
        notificationSender.send(message);
    }

    /**
     * getter
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * 추상 메서드
     * 자식이 반드시 구현해야 함
     */
    protected abstract String getPaymentType();
}