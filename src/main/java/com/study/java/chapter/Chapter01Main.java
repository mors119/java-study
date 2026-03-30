package com.study.java.chapter;
// * 실행 방법
// javac Chapter01Main.java
// java ChapterO1Main

import com.study.java.example.HelloJava;

// ? camelCase(variableName, methodName 등)와 PascalCase(ClassName, InterfaceName 등)를 씀.

// ? Class: java의 기본 단위 / 모든 코드는 이 안에 작성되야함.
public class Chapter01Main {

    // ? Method: 작업을 수행하는 코드 블록
    // main은 프로그램에 하나 이상 존재해야함.
    public static void main(String[] args) {
        // ? Statement: 하나의 명령어를 의미
        System.out.println("Chapter 01: Hello, Java!");

        // ? static 키워드가 있으면 불러서 바로 사용 가능
        HelloJava.staticHello();
        // ? static → 전역 변수 느낌 (모든 곳에 값이 공유됨)
        // ? 객체 → 개별 상태 (선언된 객체마다 값이 다름)

        // ? static 키워드가 없으면 new로 객체를 생성하고 사용해야함.
        HelloJava helloJava = new HelloJava();
        helloJava.sayHello();
    }
}
