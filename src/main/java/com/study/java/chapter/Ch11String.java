package com.study.java.chapter;

import java.util.Arrays;

/**
 * String
* */
public class Ch11String {
//    args 인자 넘기기
//    cd ./build/classes/java/main/com/study/java/chapter
//    java Ch11String abc 123 "test String"
    public static void main(String[] args) { // args는 문자 배열로 들어옴.
        for(int i = 0; i < args.length; i++) System.out.println("args[" + i + "] = " + args[i]);
        String[] name = new String[3];
        name[0] = "Kim";
        name[1] = "Park";

//        charAt 문자 하나 꺼내기
        char ch = name[0].charAt(2);
        System.out.println("ch = " + ch); // m
//        substring
        String str = name[0].substring(0, 2);
        System.out.println("str = " + str); // Ki

        char[] chArr = { 'L', 'e', 'e'};
        name[2] = new String(chArr); // char[]을 String
        System.out.println("name[2] = " + name[2]); // Lee
        char[] toCh = name[1].toCharArray(); // String을 char[]로
        System.out.println("toCh = " + Arrays.toString(toCh)); // [P, a, r, k]
    }
}
