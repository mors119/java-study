package com.study.java.chapter;

/**
* 상속, 포함
 * */
public class Ch14Inheritance {
    // 상속(inheritance): B는 A(의 자식)이다면 상속
    //    Child is a Parent 관계이면 상속
    //    Circle is a Point?  어색함 → 포함이 더 적절
    //    Circle has a Point? 자연스러움 → 포함
    class Parent { // == class Parent extends Object 이다.
        // Object는 모든 클래스의 조상이다. (Object에 정의된 함수 사용 가능)

        boolean power;
        int channel;
        int x = 10;

        void power() {
            power = !power;
            if(power) System.out.println("TV on");
            else System.out.println("TV off");
        }
    }

    // Parent를 상속 받는 child - 생성자와 초기화 블록을 제외하고 모두 상속을 받는다.
    class Child extends Parent { // 조상은 하나만 허용 extends Mom, Dad는 오류
        boolean caption;
        int x = 20;

        // 자식에서 부모의 멤버들을 활용
        void displayCaption(String text) {
            if (!power) power();
            if (caption && power) System.out.println(text);
        }

        // overriding: 조상 메서드를 변경하는 것
        // 1. 조상과 선언부 일치, 2. 접근제어자를 좁게 할 수 없음, 3. 조상보다 많은 예외 선언 불가
        @Override // 컴파일러에게 알려주는 어노테이션으로 메서드 불일치 등을 컴파일러가 검사하도록 하는 컴파일러 검사 지시문
        void power() {
            caption = !caption;
            super.power(); // 조상 메서드 호출
            if(power && caption) System.out.println("Caption on");
            else System.out.println("Caption off");
        }

        void printX() {
            System.out.println(x); // 20
            System.out.println(this.x); // 20, 자식에 x가 없으면 당연히 this.x도 부모 x를 가리킴.
            // super 조상 멤버를 구분하기 위해서 사용
            System.out.println(super.x); // 10
        }

    }

    // 포함: A는 B를 포함 한다면 (상속 말고) 포함 사용 (대부분 포함)
    class Point { // == class Point extends Object 이다.
        int x;
        int y;

        Point() {}

        // 생성자 조건
        //   1. 클래스 이름과 일치
        //   2. void 불가
        //   3. this()로 다른 생성자 호출
        //   4. 생성자 첫 줄에 반드시 생성자 호출(아니면 super() 자동 삽입됨.)
        Point(int x, int y) {
            // super(); 생략됨.
            this.x = x;
            this.y = y;
        }

        String getLocation() {
            return "x :" + x + ", y :" + y;
        }
    }

    class Circle {
        Point p = new Point(); // 포함
        int r;

        String getLocation () {
            return p.getLocation() + ", r :" + r;
        }
    }

    // class Circle extends Point {}도 가능하지만

    public static void main(String[] args) {
        
    }
}

