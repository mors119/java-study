package com.study.java.chapter;

/**
 * interface, implements
 */
public class Ch18Interface {
    // 인터페이스 (껍데기, 가이드) vs 추상 클래스 (일부 미완성, 템플릿)
    // 인터(중간)페이스(대상)의 장점
    // 1. 인터페이스를 이용해 클래스간 관계를 맺어줄 수 있다.
    // 2. 공통 표준을 만드는 것이 가능하다.
    // 3. 구현과 사용을 동시에 하여 개발 시간을 단축한다. (변경에 용의)

    // 인터페이스: 추상 메서드의 집합 + 상수 정의 가능 (선언과 구현을 분리)
    //    interface 인터페이스이름 {
    //        public static final 타입 상수명 = 값;
    //        public abstract 메서드이름(매개 변수 목록);

            // jdk 8 디폴트 메서드 추가 (기본 구현을 제공 -> 구현 클래스들에 전부 구현할 필요가 없어짐.)
            // default void newMethod() {}
            // 충돌이 생기므로 디폴트 메서드를 구현 클래스에서 오버라이딩해서 수정하면 된다.

            // jdk 9 private static 메서드 추가 (반드시 구현부가 필요)
            // static 메서드에서 호출하는 private 메서드는 static을 붙여야 한다.
            // static void staticMethod() { privateStaticMethod(); }
            // private static void privateStaticMethod() {}
    //    }

    // 클래스와 다르게 인터페이스는 다중 상속 가능
    interface Movable {
        void move(int x, int y); // public abstract 생략됨.
    }
    interface Attckable {
        void attack();
    }
    interface Fightable extends Movable, Attckable {}

    // 아래 클래스들은 Fightable라는 공통점이 생긴다.

    // implements = interface 구현
    class Tank implements Fightable {
        @Override
        public void move(int x, int y) {}
        @Override
        public void attack() {}
    }

    // abstract implements 로 일부 메서드만 구현
    abstract class Soldier extends Tank implements Fightable {
        @Override
        public void attack() {}
    }

    // 상속 및 구현 extends implements
    class Army extends Tank implements Fightable {
        @Override
        public void attack() {}
    }

    public void main(String[] args) {
        Ch18Interface outer = new Ch18Interface();
        Fightable f = (Fightable) outer.new Army();

        if(f instanceof Army) System.out.println("Army는 Fightable 인터페이스를 구현함.");
        if(f instanceof Tank) System.out.println("Tank는 Fightable 인터페이스를 구현함.");

    }

    // B가 변경이 (I에 영향을 미칠 정도의 변경이 없다면) A에게 영향을 미치지 않는다.
    // B 대신 I를 사용하므로 A - I - B로 관계가 생성 (인터페이스를 통해 관계를 생성)
    // B를 A에 드러내지 않아도 됨.
    class A {
        public void methodA(I i) {
            i.method();
        }
    }
    interface I {
        public abstract void method();
    }
    class B implements I {
        @Override
        public void method() {
            System.out.println("method() in B");
        }
    }
}
