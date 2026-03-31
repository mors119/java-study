package com.study.java.chapter;

class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}

class UserNotFoundException extends BusinessException {
    public UserNotFoundException(Long id) {
        super("사용자를 찾을 수 없습니다. id=" + id);
    }
}

class ExternalServiceException extends BusinessException {
    public ExternalServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

class UserRepository {

    public String findUserNameById(Long id) {
        if (id == 1L) {
            return "kim";
        }
        return null;
    }
}

class PaymentClient {
    public void call() throws java.io.IOException {
        throw new java.io.IOException("Connection reset");
    }
}

class UserService {

    private final UserRepository userRepository;
    private final PaymentClient paymentClient;

    public UserService(UserRepository userRepository, PaymentClient paymentClient) {
        this.userRepository = userRepository;
        this.paymentClient = paymentClient;
    }

    public String getUserName(Long id) {
        String name = userRepository.findUserNameById(id);
        if (name == null) {
            throw new UserNotFoundException(id);
        }
        return name;
    }

    public void requestPayment() {
        try {
            paymentClient.call();
        } catch (java.io.IOException e) {
            throw new ExternalServiceException("결제 서버 호출 실패", e);
        }
    }
}

public class Chapter11ExceptionHandling {

    public static void main(String[] args) {
        UserService userService = new UserService(new UserRepository(), new PaymentClient());

        try {
            String name = userService.getUserName(2L);
            System.out.println(name);
        } catch (UserNotFoundException e) {
            System.out.println("[사용자 예외 처리] " + e.getMessage());
        }

        try {
            userService.requestPayment();
        } catch (ExternalServiceException e) {
            System.out.println("[외부 서비스 예외 처리] " + e.getMessage());
            System.out.println("원인: " + e.getCause().getMessage());
        }
    }
}