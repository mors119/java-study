package com.study.java.chapter;

import java.util.Scanner;

/**
 * 다차원 배열 (Multi-dimensional Arrays)
* */
public class Ch12MultiArrays {

    static Ch12Example example = new Ch12Example();

    public static void main(String[] args) {
//        이차원 배열
//        int[][] score = new int[4][3];
//        int[][] score = {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}};

//        다차원 가변 배열
        int[][] score = new int[2][]; // 다른 길이인 경우 비워둠
        score[0] = new int[2];
        score[1] = new int[3];

//        다차원 배열 예제
        Scanner scanner = new Scanner(System.in);
        System.out.println("원하는 예제를 선택하세요.");
        System.out.println("1. ship 2. binggo 3. matrix 4. word");
        switch (scanner.nextInt()) {
            case 1 -> example.shipGame();
            case 2 -> example.binggo();
            case 3 -> example.matrix();
            case 4 -> example.word();
            default -> System.out.println("잘못된 입력입니다.");
        }
    }
}
