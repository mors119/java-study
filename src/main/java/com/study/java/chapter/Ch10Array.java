package com.study.java.chapter;

import java.util.Arrays;

/**
 * 배열 (Array) 활용
* */
public class Ch10Array {
    public static void main(String[] args) {
//        섞기
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        for (int i = 0; i < arr.length * 2; i++) {
            int j = (int) (Math.random() * arr.length);
            int tmp = arr[0];
            arr[0] = arr[j];
            arr[j] = tmp;
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
//        빈도수 구하가
        int[] freq = new int[10];
        for (int i = 0; i < arr.length; i++) arr[i] = (int) (Math.random() * 10) + 1; // 1 ~ 10
        for (int i = 0; i < arr.length; i++) freq[arr[i] - 1]++;
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        for (int i = 0; i < freq.length; i++) System.out.printf("[%d] = %-5d", i + 1, freq[i]);
    }
}