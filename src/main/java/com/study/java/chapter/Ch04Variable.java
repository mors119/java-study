package com.study.java.chapter;

import java.util.Scanner;

/**
* Printf
 * */
public class Ch04Variable {
    public static void main(String[] args) {
        // 형식화된 출력 printf(%숫자/형식/길이/정렬)
        // %b = 불리언
        System.out.printf("boolean = %b%n", true);
        // %d = 정수 (%o = 8진수, %x = 16진수)
        System.out.printf("int = %d%n", 10);
        // %f = 실수 (%e = 지수(exponent)) %전체자리(소수점 포함).소수점아래자리f
        System.out.printf("float = %14.10f (퍼센트 전체자리: 14 소수점 자리: 10)%n", 3.1415926535347);
        // %s = 문자열
        System.out.printf("str = [%10s]%n", "Hello");
        System.out.printf("str ('-'로 왼쪽 정렬) = [%-10s]%n", "Hello");
        // %c = 문자
        System.out.printf("char = %c%n", 'A');
        // %n = 줄바꿈
        System.out.printf("줄바꿈 = %n");

        // 입력 받기
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성 (System.in = 키보드)

        String input = scanner.nextLine(); // 입력받은 한줄(String)을 input에 저장 (next는 String 한 단어)
        System.out.println("input = " + input);

        int num = scanner.nextInt(); // int로 값 받기
        System.out.println("num = " + num);
        
    }
}
