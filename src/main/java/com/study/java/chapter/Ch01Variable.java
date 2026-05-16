package com.study.java.chapter;

/**
* Variable
*/
public class Ch01Variable {
    /**
     * main + tab = main 메서드 생성
     */
  public static void main(String[] args) {
      int age; // 변수 선언 - 저장 공간 만들기
      age = 10; // 쓰기 - 변수에 값 대입
      System.out.println(age); // 읽기 - 변수에 저장된 값 읽어오기 / sout
      System.out.println("age = " + age); // soutv
      age = age + 1; // 값 변경
      System.out.println("age = " + age); // age.soutv

      // 두 변수의 값 교환
      int a = 10;
      int b = 20;

      int tmp = a;
      a = b;
      b = tmp;
      System.out.println("a = " + a);
      System.out.println("b = " + b);
  }
}
