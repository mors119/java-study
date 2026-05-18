package com.study.java.chapter;

import java.util.Scanner;

/**
 * 반복문 (Loops)
 * while, for, do-while
 * */
public class Ch08FlowControls {
    public static void main(String[] args) {
//      while (조건식) { 결과가 참인 동안 반복 } : 반복 수를 모를 때 유리
        int i = 0; // 초기화
        while (i < 5) { // 조건식 (조건식 생략 시 오류)
            i++; // 증감식
            if(i % 3 == 2) continue;
            System.out.println("i = " + i);
        }

//      for (초기화; 조건식; 증감식) { 결과가 참인 동안 반복 }
        for (; i > 0; i--) { // for(;;)처럼 생략 가능
            System.out.println("i = " + i);
        }

//      향상된 for문 for (타입 변수명: 배열 또는 컬렉션) {}
        int[] arr = {1, 2, 3, 4, 5};
        for (int a : arr) {
            System.out.println("a = " + a);
        }

//      do-while 1번은 무조건 실행
        int input, answer;
        Scanner scanner = new Scanner(System.in);

        answer = (int) (Math.random() * 10) + 1;
        do {
            input = scanner.nextInt();
            if (input > answer) {
                System.out.println("Down");
            } else if (input < answer) {
                System.out.println("Up");
            }
        } while (input != answer);
        scanner.close();
        System.out.println("Correct Answer = " + answer);

//       labeled for문
        Loop1 : for (int j = 1; j <= 5; j++) {
            System.out.println("j = " + j);
            for (int h = 1; h <= 3; h++) {
                if (h == 2)
//                    continue Loop1; // 건너 뛰고 Loop1로 이동
                    break Loop1; // Loop1 종료
                System.out.println("h = " + h);
            }
        }
    }
}
