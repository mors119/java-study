package com.study.java.example;

public class HelloJava {

    // ? static 키워드가 있으면 불러서 바로 사용 가능
    public static void staticHello() {
        System.out.println("Hello, static!");
    }

    // ? static 키워드가 없으면 new로 객체를 생성하고 사용해야함.
    public void sayHello() {
        System.out.println("Hello, no-static!");
    }

}
