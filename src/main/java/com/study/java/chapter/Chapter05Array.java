package com.study.java.chapter;

import java.util.Arrays;

public class Chapter05Array {
    public static void main(String[] args) {
        // ? 1. 배열 선언
        int[] nums; // int nums[]도 가능하지만 비권장
        nums = new int[3]; // 길이가 5인 int 배열
        // 또는 int nums = new int[3];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 2;

        // ? 2. 배열 초기화 시 기본값
        int[] numbers = new int[3]; // [0, 0, 0]
        boolean[] flags = new boolean[2];// [false, false]
        String[] words = new String[3];  // [null, null, null]

        // ? 3. 선언과 동시에 값 할당
        int[] array = {1, 2, 3}; // [1, 2, 3]
        int[] array2 = new int[]{1, 2, 3}; // [1, 2, 3]
        // int[] array3 = new int[3]{1, 2, 3}; 불가능

        // ? 4. 배열 출력
        // ? System.out.println(arr); 이렇게 하면 주소 출력됨
        // ✔ 방법 1: 반복문
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        // ✔ 방법 2: 향상된 for문
        for (boolean num : flags) {
            System.out.println(num);
        }
        // ✔ 방법 3: Arrays (추천)
        System.out.println(Arrays.toString(words));

        // ? 5. 배열 복사
        int[] copy = array; // 주소 복사 (얕은 복사) -> 배열 내용 변경 시 같이 변경
        int[] a = array.clone(); // 간단할 때 사용
        int[] b = Arrays.copyOf(array2, array2.length); // 가장 많이 사용
        System.arraycopy(nums, 0, nums, 0, nums.length); // 고성능이 필요할 때 사용

        // ? 6. 배열 유틸
        Arrays.sort(a);
        System.out.println(Arrays.toString(a)); // [1, 2, 3]
        // 비교
        System.out.println(Arrays.equals(copy, b)); // true
        // 채우기
        int[] c = new int[5];
        Arrays.fill(c, 7);
        System.out.println(Arrays.toString(c)); // [7,7,7,7,7]

        // ? 7. 다차원 배열
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6}
        };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }

        // 8. 가변 배열
        int[][] scores = new int[3][];
        // 각 학생별 과목 수 다름
        scores[0] = new int[]{90, 80};       // 1번 학생 (2과목)
        scores[1] = new int[]{70, 85, 100};  // 2번 학생 (3과목)
        scores[2] = new int[]{95};           // 3번 학생 (1과목)
        // 출력
        for (int i = 0; i < scores.length; i++) {
            System.out.println("학생 " + (i + 1));
            for (int j = 0; j < scores[i].length; j++) {
                System.out.println("  점수: " + scores[i][j]);
            }
        }
    }
}
