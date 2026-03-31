package com.study.java.chapter;

/**
 * sealed interface
 * - 이 인터페이스를 구현할 수 있는 타입을 제한한다.
 * - permits 뒤에 허용할 구현체를 명시한다.
 */
sealed interface PaymentResult
        permits PaymentSuccess, PaymentFailure, PaymentPending {
}

/**
 * final:
 * - 더 이상 상속 불가
 * - sealed 타입의 허용 구현체로 자주 사용됨
 */
final class PaymentSuccess implements PaymentResult {
    private final String transactionId;

    public PaymentSuccess(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}

final class PaymentFailure implements PaymentResult {
    private final String reason;

    public PaymentFailure(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}

/**
 * non-sealed:
 * - sealed를 풀어서, 이 클래스부터는 다시 자유롭게 상속 가능
 */
non-sealed class PaymentPending implements PaymentResult {
    private final String message;

    public PaymentPending(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

public class Chapter10SealedInterface {

    public static void main(String[] args) {
        PaymentResult result1 = new PaymentSuccess("TXN-1001");
        PaymentResult result2 = new PaymentFailure("잔액 부족");
        PaymentResult result3 = new PaymentPending("승인 대기 중");

        printResult(result1);
        printResult(result2);
        printResult(result3);
    }

    public static void printResult(PaymentResult result) {
        if (result instanceof PaymentSuccess success) {
            System.out.println("결제 성공: " + success.getTransactionId());
        } else if (result instanceof PaymentFailure failure) {
            System.out.println("결제 실패: " + failure.getReason());
        } else if (result instanceof PaymentPending pending) {
            System.out.println("결제 대기: " + pending.getMessage());
        }
    }
}