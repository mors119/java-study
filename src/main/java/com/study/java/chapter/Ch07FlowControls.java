package com.study.java.chapter;

/**
 * 조건문 (Conditionals)
 * if, switch
 */
public class Ch07FlowControls {
    public static void main(String[] args) {
        char c = 'a';
//    if(조건식) ture일 때 수행될 문장
        if (c >= 'a' && c <= 'z') {
            System.out.println("소문자.");
        } else if (c >= 'A' && c <= 'Z') {
            System.out.println("대문자.");
        } else {
            // 중첩 if 문의 경우 else는 가까운 if와 결합됨.
            System.out.println("영문자 아님.");
        }

//      switch 문 switch (조건식) { case 값: break; default: 일치하는게 없는 경우 }
//        break가 없는 경우 아래로 계속 진행된다.
//        if문과 다르게 반드시 결과를 반환해야한다. (컴파일러가 체크함.)
        int random = (int) (Math.random() * 3) + 1; // 1, 2, 3 (random은 0.0 ~ 0.999 값을 반환)
        switch (random) { // 조건식에 정수값, 문자열, 참조형만 가능 (변수와 실수는 불가능)
            case 1, 2: // 여러가지를 쓸 수 있음.
                {
                    System.out.println("1");
                    System.out.println("2");
                    break;
                }
            case 3:
                System.out.println("3");
                break;
            default: // 조건식이 case에 없는 경우
                System.out.println("random 함수 오류");
        }
//      변수에 switch문 바로 쓰기
        char ch = switch(random) {
            case 1:  yield '1';
            case 2:  yield '2';
            case 3:  yield '3';
            default: yield '0';
        };
        System.out.println("ch = " + ch);

//      switch 식:  -> 는 break;를 쓰지 않는 실수를 막아줌.
        switch (random) {
            case 1, 2 -> // 여러가지를 쓸 수 있음.
                System.out.println("1, 2");
            case 3 ->
                System.out.println("3");
            default -> // 조건식이 case에 없는 경우
                System.out.println("random 함수 오류");
        }
        char ch2 = switch(random) {
            case 1->   '1';
            case 2->   '2';
            case 3->   '3';
            default->  '0';
        };
        System.out.println("ch2 = " + ch2);
    }
}
