package com.study.java.chapter; // "javac -d . 현재클래스"를 하면 package 경로 아래에 class 파일이 생성됨.

// import java.util.* 컴파일러에게 정보 제공(*는 클래스만 불러올 수 있음. java.* 같은 건 불가)
/**
 * modifier,
* import, package
*/
public class Ch15Package {
    // static: 클래스의, 공통적인
    // 적용 대상: 멤버 변수, 메서드, 초기화 블록
    static int width = 200; // 클래스 변수
    static { // 클래스 초기화 블럭
        // static 변수의 초기화 수행
    }
    static int max (int a, int b) { // 클래스 메서드(static 메서드)
        return a > b ? a : b;
    }

    // final: 마지막의, 변경될 수 없는
    // 적용 대상: 클래스, 변수, 메서드
    final class FinalTest { // 조상이 될 수 없음 (extends 불가능)
        final int MAX = 10; // 상수 (값 변경 불가)
        int MIN;
        final void getMax() { // 오버라이딩 할 수 없는 메서드 (변경 불가)
            final int lv = MAX; // 값을 변경할 수 없는 지역 변수
        }
        FinalTest(int min) {
            MIN = min; // 상수 초기화 객체 생성 시마다 새로운 상수 적용 (물론 final class에서는 의미 x)
        }
    }

    // abstract: 추상의, 미완성의
    // 적용 대상: 클래스, 메서드
    // 추상 메서드를 하나라도 가지고 있으면 클래스에 abstract를 써줘야함.
    abstract class AbstractTest { // 추상 클래스 (추상 메서드를 포함한 클래스)
        abstract void move(); // 추상 메서드 (구현부가 없는 메서드)
    }

    // 접근 제어자 (access modifier): 데이터 보호(캡슐화) & 외부에서 불필요
    // public     | 같은 클래스 | 같은 패키지 | 자손 클래스 | 전체 |
    // protected  | 같은 클래스 | 같은 패키지 | (다른 패키지의) 자손 클래스
    // (default)  | 같은 클래스 | 같은 패키지 |
    // private    | 같은 클래스 |

    // 접근 제어자 사용 대상
    // 클래스 | public, (default)
    // 메서드, 멤버 변수 | public, protected, (default), private
    // 지역 변수 | 없음.

    public class Time {
        private int hour; // 외부에서 직접 접근(읽기, 쓰기)하지 못하도록 하고 메서드를 통해 값을 전달
        private int minute;
        private int second;

        public int getHour() { // get 메서드를 생성해서 외부로 값을 전달
            return hour;
        }
        public void setHour(int hour) { // set 메서드
            if (hour < 0 || hour > 23) return; // set은 읽기보다 더 중요하므로 값을 확인하고 변경
            this.hour = hour;
        }
    }

    // 객체 디자인 패턴 중 싱글톤 예제 - 사용 시 new Singleton이 아니라 Singleton.getInstance()로 접근
//    public class Singleton {
        // 클래스가 로딩될 때 단 하나의 객체를 생성
//        private static final Singleton instance = new Singleton();
        // 외부에서 new Singleton() 호출을 막기 위한 private 생성자
//        private Singleton() {
            // 초기화 코드
//        }
        // 유일한 객체를 반환하는 static 메서드
//        public static Singleton getInstance() {
//            return instance;
//        }
//    }

}
