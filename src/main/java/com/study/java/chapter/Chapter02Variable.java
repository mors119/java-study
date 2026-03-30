package com.study.java.chapter;

public class Chapter02Variable {
    static final int STATIC_NUM = 15; // ? 클래스 상수 (공용 상수)
    // ? 다른 클래스에서 "Chapter02Variable.STATIC_NUM"으로 사용
    public static final int PUBLIC_STATIC_NUM = 15; // ? 공용 상수
    // ? 다른 클래스에서 "STATIC_NUM"으로 사용

    public static void main(String args[]) {
        int num = 3; // 일반 변수
        final int NUM = 4; // 상수

        System.out.println(num + NUM + STATIC_NUM);
    }
}
