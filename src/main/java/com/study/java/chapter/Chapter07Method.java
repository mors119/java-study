package com.study.java.chapter;

// 클래스
class Calculator {

    // ? 필드 (캡슐화)
    private String owner;

    // ? 생성자: 객체가 호출이 될 떄 자동으로 호출되는 메서드
    // 생성자 (1)
    public Calculator(String owner) {
        this.owner = owner;
    }

    // ? 생성자 오버로딩 (2) this() → 다른 생성자 호출
    public Calculator() {
        this("Guest"); // 다른 생성자 호출
    }

    // ? 메서드
    public String owner() {
        return owner;
    }

    // ? 메서드 오버로딩 (같은 이름의 다른 타입)
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    // ? 가변 인자 메서드 (int 배열로 처리됨.)
    public int sumAll(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    // ? 재귀 호출 (팩토리얼)
    public int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    // ? 매개변수 + 접근 지정자
    public void printResult(String message, int value) {
        log(message + " = " + value);
    }

    // ? private 메서드 (외부 접근 불가)
    private void log(String msg) {
        System.out.println("[" + owner + "] " + msg);
    }
}

public class Chapter07Method {

    public static void main(String[] args) {

        // 생성자 사용
        Calculator calc = new Calculator("Mars");
        Calculator calc2 = new Calculator();
        System.out.println(calc.owner()); // Mars
        System.out.println(calc2.owner()); // Guest

        // 메서드 호출 (오버로딩)
        int result1 = calc.add(10, 20);
        double result2 = calc.add(1.5, 2.5);

        calc.printResult("int add", result1);
        calc.printResult("double add", (int) result2);

        // 가변 인자
        int sum = calc.sumAll(1, 2, 3, 4, 5);
        calc.printResult("sumAll", sum);

        // 재귀 호출
        int fact = calc.factorial(5);
        calc.printResult("factorial", fact);
    }
}