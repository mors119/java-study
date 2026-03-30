package com.study.java.chapter;

public class Chapter04Loop {
    public static void main(String[] args) {
        // 1. for 문
        for (int i = 0; i < 5; i++) {
            System.out.println("for 문: " + i);
        }

        // 2. while 문
        // 조건을 먼저 검사 후 실행
        int j = 0;
        while (j < 5) {
            j++;
            if (j > 4) {
                continue; // 조건이 맞으면 건너뜀
            }
            System.out.println("while 문: " + j);

        }

        // 3. do-while 문
        // ? 실행 후 조건을 검사 (조건이 맞지 않아도 최초 한 번은 실행)
        int k = 0;
        do {
            System.out.println("do-while 문: " + k);
            k++;
            if (k % 2 == 0 && k >= 4) {
                break; // 조건이 맞으면 종료
            }

            } while (k < 5);
    }
}
