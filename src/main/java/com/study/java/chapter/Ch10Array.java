package com.study.java.chapter;

import java.util.Arrays;

/**
 * 배열 (Array)
* */
public class Ch09Array {
    public static void main(String[] args) {
//        배열: 같은 타입의 변수를 하나로 묶은 것

//        타입[] 변수 이름; 배열을 선언 (배열을 다루기 위한 참조 변수)
//        변수 이름 = new 타입[길이]; 배열을 생성 (실제 저장 공간 생성) 길이는 0 ~ n 개까지 가능, 배열 길이 int 최대값 근사치까지 허용.
        int[] arr = new int[5]; // 0, 0, 0, 0, 0 생성
        System.out.println("arr.length = " + arr.length); // 배열은 한 번 만들면 실행 중 길이를 변경할 수 없다.
        arr[0] = 100;
        arr[1] = 200;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }


//        초기값 지정
        int[] arr2 = new int[] {1, 2, 3, 4, 5}; // 두 줄로 작성 가능
//      또는  int[] arr2 = {1, 2, 3, 4}; // 이 방법은 한줄로 작성해야함.
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }
//        for 문 대신 Arrays.toString 사용 가능
        System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));


//        배열 복사(길이 변경) (길이 변경이 안되므로 생성 복사)
        int[] tmp = new int[arr2.length * 2]; // 1. arr2 길이의 2배인 배열 선언
//        for (int i = 0; i < arr2.length; i++) tmp[i] = arr2[i]; // 2. tmp에 복사
//        arr2 = tmp; // 3. 참조변수 arr2가 새로운 배열을 가리키도록
//        System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));

//        배열 복사 메서드 이용 System.arraycopy(from arr, from arr start, to arr, to arr start, length)
        System.arraycopy(arr2, 0, tmp, 0, arr2.length);
        System.out.println("Arrays.toString(tmp) = " + Arrays.toString(tmp));
    }
}
