package com.study.java.chapter;

/**
 * 객체지향 프로그래밍(Object-Oriented Programming, OOP)
 */
public class Ch13ObjectOriented {

    // 클래스: 객체를 만들기 위한 설계도
    // 객체/인스턴스: 클래스를 바탕으로 실제 메모리에 생성된 대상

    // 객체의 구성 요소
    // 속성(property) -> 멤버 변수(member variable)
    // 기능(function) -> 메서드(method)

    // 클래스 변수: 클래스에 소속되며, 클래스당 1개만 생성된다.
    // 모든 인스턴스가 공유하는 공통 데이터에 사용한다.
    static String color;

    static class Tv {

        // 생성자: 객체 생성 직후 초기화를 담당한다.
        // 리턴 타입이 없고, 클래스 이름과 같아야 한다.
        // 생성자를 하나도 작성하지 않으면 컴파일러가 기본 생성자를 자동으로 추가한다.
        Tv() {
        }

        // new는 객체 생성을 담당하고, 생성자는 초기화를 담당한다.
        Tv(boolean power, int channel) {
            // 다른 생성자를 호출할 때는 반드시 생성자 첫 줄에 작성해야 한다.
            // this(); // Tv() 생성자 호출

            this.power = power; // this는 객체 자신을 기리키는 참조 변수
            this.channel = channel;
        }

        // 인스턴스 변수: 객체마다 따로 생성되는 개별 데이터
        boolean power;
        int channel;

        // 인스턴스 메서드: 인스턴스 변수와 함께 동작하는 기능
        void power() {
            power = !power;
            // void 메서드에서는 return을 생략할 수 있다.
        }

        void channelUp() {
            ++channel;
        }

        void channelDown() {
            --channel;
        }

        boolean sound(boolean up) {
            if (up) {
                System.out.println("볼륨을 올렸습니다.");
                return true;
            }

            // 반환 타입이 boolean이면 모든 실행 경로에서 boolean 값을 반환해야 한다.
            System.out.println("볼륨 높이기를 실패했습니다.");
            return false;
        }
    }

    // static 메서드: 객체 생성 없이 클래스 이름으로 호출할 수 있다.
    // 주로 매개변수만으로 처리 가능한 기능에 사용한다.
    static void printColorOption(String col) {
        System.out.println("현재 색상은 " + col + "이고, 다른 옵션으로는 blue, green이 있습니다.");
    }

    // 오버로딩(overloading)
    // 같은 이름의 메서드를 여러 개 정의할 수 있다.
    // 매개변수의 타입, 개수, 순서로 구분한다.
    // 반환 타입만 다른 것은 오버로딩으로 인정되지 않는다.
    static int printColorOption(int col) {
        System.out.println("현재 색상은 " + col + "이고, 다른 옵션으로는 112233이 있습니다.");
        return col;
    }

    // 가변 인자: 인자의 개수가 정해져 있지 않을 때 사용한다.
    // 가변 인자는 매개변수 목록의 마지막에만 작성할 수 있다.
    static void printColorOption(int col, String... options) {
        System.out.println("현재 색상은 " + col + "입니다.");

        for (String option : options) {
            System.out.println("옵션 색상: " + option);
        }
    }

    public static void main(String[] args) {

        // 객체 생성과 사용
        Tv t1 = new Tv();

        // 클래스 변수는 클래스 내부에서는 변수명만으로 접근할 수 있다.
        color = "red";

        // 인스턴스 변수는 객체를 통해 접근한다.
        t1.channel = 7;

        // 인스턴스 메서드 호출
        t1.channelDown();
        t1.sound(true);

        System.out.println("t1.channel = " + t1.channel);

        // 참조 변경 예시
        // Tv t2 = new Tv();
        // t2 = t1;
        // 이 경우 t2는 t1과 같은 객체를 참조한다.
        // 기존에 t2가 참조하던 객체는 더 이상 참조되지 않으면 GC 대상이 된다.

        // 객체 배열
        Tv[] tvArr = new Tv[2];

        // 객체 배열은 참조 변수 배열만 만든다.
        // 각 칸에 실제 객체를 따로 생성해서 넣어야 한다.
        tvArr[0] = new Tv();
        tvArr[1] = new Tv();

        tvArr[0].channel = 10;
        tvArr[1].channel = 20;

        System.out.println("tvArr[0].channel = " + tvArr[0].channel);
        System.out.println("tvArr[1].channel = " + tvArr[1].channel);
    }
}