package com.study.java.chapter;

public class Chapter03Conditional {
    public static void main(String[] args) {
        int score = 85;

        // 1. if-else if-else 문
        if (score >= 90) {
            System.out.println("A 학점");
        } else if (score >= 80) {
            System.out.println("B 학점");
        } else if (score >= 70) {
            System.out.println("C 학점");
        } else {
            System.out.println("F 학점");
        }

        // 2. switch 문 (Java 12+ Switch Expressions 스타일 포함)
        String grade = "B";
        switch (grade) {
            case "A":
                System.out.println("최우수");
                break;
            case "B":
                System.out.println("우수");
                break;
            default:
                System.out.println("보통");
        }

        // 3. 삼항 연산자 (Ternary Operator)
        String result = (score >= 60) ? "합격" : "불합격";
        System.out.println("결과: " + result);
    }

}
