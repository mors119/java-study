package com.study.java.chapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("name=" + name + ", age=" + age);
    }
}


public class Chapter12List {
    public static void main(String[] args) {
        int [] arr = new int[2];
        arr[0] = 10;
        arr[1] = 20;

        System.out.println(Arrays.toString(arr));
        /*
        배열: 크기 고정, 타입 안전. 빠름, 기능 적음
        리스트: 크기 가변, 순서 있음. 실무형 컬렉션
         */
        List<String> fruits = new ArrayList<>(); // 부모 타입(List)으로 자식 객체(ArrayList)를 받는 다형성 구조

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("전체 목록: " + fruits);
        System.out.println("첫 번째 과일: " + fruits.get(0));
        System.out.println("개수: " + fruits.size()); // length 대신 size 사용

        fruits.remove("Banana");

        System.out.println("삭제 후 목록: " + fruits);
        System.out.println("Apple 포함 여부: " + fruits.contains("Apple"));

        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }

        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 리스트에 객체 넣기
        List<User> users = new ArrayList<>();

        users.add(new User("kim", 20));
        users.add(new User("Minji", 22));

        for (User user : users) {
            user.introduce();
        }

    }
}
