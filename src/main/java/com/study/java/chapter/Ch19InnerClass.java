package com.study.java.chapter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 내부 클래스(중첩 클래스)
 */
public class Ch19InnerClass {
    // 내부 클래스:
    // class A {
    //     class B {} // 내부 클래스
    // }
    // A만 B를 사용하는 경우
    // 장점: 1. 내부 클래스에서 외부 클래스 멤버들을 쉽게 접근할 수 있다. 2. 코드의 복잡성을 줄일 수 있다.

    // 변수의 3가지 종류와 유사(접근 제어자 사용 가능)
    //    class Outer {             -> class Outer {
    //        int iv = 0;           ->  class InstanceInner {}
                                    // static 붙은 클래스만 static 멤버 정의 가능 (jdk 16부터는 허용)
                                    // 당연하게 static 멥버는 인스턴스 멤버에 접근 불가 (인스턴스 멤버는 메모리에 없을 수도 있음.)
    //        static int cv = 0;    ->  static class StaticInner { static int v; }
    //
    //        void method() {       -> void method() {
    //            int lv = 0;       ->     class LocalInner {}}
    //        }                     ->  }
    //    }                         -> }

    private int outerIv = 0;
    static  int outerCv = 0;

    class InstanceInner {
        int iiv  = outerIv;  // 외부 클래스의 private멤버도 접근가능
        int iiv2 = outerCv;
    }

    static class StaticInner {
        // 스태틱 클래스는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
        // int siv = outerIv;
        int siv = 0;
        static int scv = outerCv;
    }

    void myMethod() {
        int lv = 0; // 실제론 상수로 취급
        final int LV = 0;  // JDK1.8부터 final 생략 가능

        class LocalInner {
            int liv  = outerIv;
            int liv2 = outerCv;
            //	외부 클래스의 지역변수는 final이 붙은 변수(상수)만 접근가능
			// int liv3 = lv;	// 에러!!!(JDK1.8부터 에러 아님)
            int liv4 = LV;	// OK
        }
    }
    
    public static void main(String[] args) {
        // 인스턴스 클래스의 인스턴스를 생성하려면
        // 1. 외부 클래스 객체를 생성
        // 2. 내부 인스턴스 클래스 객체 생성
        Ch19InnerClass outer = new Ch19InnerClass();
        Ch19InnerClass.InstanceInner inner = outer.new InstanceInner();
        System.out.println("inner.iiv = " + inner.iiv);
        System.out.println("Ch19InnerClass.StaticInner.scv = " + Ch19InnerClass.StaticInner.scv);
        
        // 스태틱 내부 클래스의 인스턴스는 외부 클래스를 생성하지 않아도됨.
        Ch19InnerClass.StaticInner staticInner = new Ch19InnerClass.StaticInner();
        System.out.println("staticInner.siv = " + staticInner.siv);
    }
}

// 이름이 없는 클래스로, 선언과 동시에 객체 인스턴스를 생성하는 방식
class AnonymousClass {
    // new 조상 클래스 이름 () {}
    // 조상인 Object()를 사용
    Object iv = new Object(){ void method(){} };        // 익명 클래스
    static Object cv = new Object(){ void method(){} }; // 익명 클래스

    void myMethod() {
        Object lv = new Object(){ void method(){} };	  // 익명 클래스
    }
}

// 이 클래스를 익명 클래스로 변경하면 아래처럼 바뀐다.
//class AnonymousClassTest{
//    public static void main(String[] args) {
//        Button b = new Button("Start");
//        b.addActionListener(new EventHandler());
//    }
//}
//
//class EventHandler implements ActionListener {
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("ActionEvent occurred!!!");
//    }
//}

// 부모(조상) 클래스(인터페이스)를 쓰고 바로 이어서 함수 작성
class AnonymousClassChange{
    public static void main(String[] args) {
        Button b = new Button("Start");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ActionEvent occurred!!!");
            }
        });
    }
}

