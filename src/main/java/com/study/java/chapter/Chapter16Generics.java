package com.study.java.chapter;

import java.util.ArrayList;
import java.util.List;

// 제네릭 클래스 만들기
class Box<T> {
//    T = 타입 변수 (Type parameter)
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

public class Chapter16Generics {

    // 제네릭 메서드
    public static <T> void print(T value) {
        System.out.println(value);
    }

    public static void main (String[] args) {
        /* 제네릭이 없었을 때 아래와 같은 오류가 생겼다.
        List list = new ArrayList(); // 타입 없음

        list.add("Hello");
        list.add(123); // 섞임

        String value = (String) list.get(0); // 캐스팅 필요
        String error = (String) list.get(1); // 런타임 오류
         */

        List<String> list = new ArrayList<>();

        list.add("Hello");
        // list.add(123); // 컴파일 에러

        String value = list.get(0); // 캐스팅 필요 없음

        Box<String> box = new Box<>();

        box.set("Hello");

        String boxValue = box.get();
        System.out.println(boxValue);
    }
}

/*
    와일드카드

    List<?> list;
    의미: 어떤 타입이든 가능 (읽기 전용 느낌)

    ? extends T
    List<? extends Number>
    의미: Number 또는 그 자식만

    ? super T
    List<? super Integer>
    의미: Integer 또는 그 부모
 */
