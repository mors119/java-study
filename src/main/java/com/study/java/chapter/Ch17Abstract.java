package com.study.java.chapter;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 추상 클래스, 팩토리 메서드
 */
public class Ch17Abstract {
    // 추상 클래스 - 미완성(블록x) 설계도, 템플릿 역할
    // 클래스간 공통점을 찾아 공통 조상을 만듬.
    // 다른 클래스의 부모 역할만 한다.
    abstract class Player {
        int currentPos;

        Player(int currentPos) {
            this.currentPos = currentPos;
        }

        abstract void play(int pos);
        abstract void stop();
        void play() {
            play(currentPos); // 추상 메서드를 사용 가능
        }
    }
    class AudioPlayer extends Player {
        AudioPlayer(int currentPos) {
            super(currentPos);
        } // 초기화를 위해 필요
        void play(int pos) {}
        void stop() {}
    }
    // 다른 Player 클래스를 만들 때도 공통부분을 작성할 필요가 없으므로 코드가 간결해지고 누락을 막음.
    class VideoPlayer extends Player {
        VideoPlayer(int currentPos) {
            super(currentPos);
        }
        void play(int pos) {}
        void stop() {}
    }

    // 팩토리 메서드
    public static void main(String[] args) {
        Ch17Abstract outer = new Ch17Abstract();
        AudioPlayer player = outer.new AudioPlayer(0);

        // Calendar cal = new Calendar(); // 추상 클래스는 인스턴스를 생성할 수 없음.
        Calendar calg = new GregorianCalendar(); // 가능하지만 경우에 따라 변경해야하므로 불리한 점이 있음.
        Calendar cal2 = Calendar.getInstance(); // 팩토리 메서드 (getInstance 가 적절한 걸 반환함.)



        Animal animal1 = Animal.create("dog");
        Animal animal2 = Animal.create("cat");

        animal1.sound(); // 멍멍
        animal2.sound(); // 야옹
    }

}

// 팩토리 메서드: 객체 생성을 대신 수행하는 정적 메서드
// 대표적인 팩토리 메서드: Calendar.getInstance() LocalDate.now() List.of() Optional.of() Path.of()
abstract class Animal {
    abstract void sound();

    // 팩토리 메서드
    public static Animal create(String type) {
        if (type.equals("dog")) {
            return new Dog();
        } else if (type.equals("cat")) {
            return new Cat();
        }

        throw new IllegalArgumentException("Unknown type");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("야옹");
    }
}
