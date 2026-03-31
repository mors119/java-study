package com.study.java.chapter;

import com.study.java.example.Animal;
import com.study.java.example.Cat;
import com.study.java.example.Dog;
import com.study.java.example.Engine;
import com.study.java.example.Car;

public class Chapter08InheritancePolymorphism {

    public static void main(String[] args) {

        // -----------------------------
        // 1. 상속
        // -----------------------------
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Nabi", 2);

        dog.speak();
        dog.breathe(); // final 메서드
        dog.fetch();

        System.out.println();

        cat.speak();
        cat.breathe();
        cat.climb();

        System.out.println();

        // -----------------------------
        // 2. Object 클래스
        // 모든 클래스는 Object를 상속받음
        // toString() 사용 가능
        // -----------------------------
        System.out.println(dog.toString());
        System.out.println(cat.toString());

        System.out.println();

        // -----------------------------
        // 3. static
        // 클래스 이름으로 직접 접근
        // -----------------------------
        System.out.println("생성된 Animal 수: " + Animal.getCount());

        System.out.println();

        // -----------------------------
        // 4. 다형성
        // 부모 타입으로 자식 객체 참조
        // -----------------------------
        Animal a1 = new Dog("Choco", 4, "Poodle");
        Animal a2 = new Cat("Mimi", 1);

        // 실행 시 실제 객체 기준으로 오버라이딩 메서드 호출
        a1.speak(); // Dog.speak()
        a2.speak(); // Cat.speak()

        System.out.println();

        // -----------------------------
        // 5. 다형성의 한계
        // 부모 타입으로 참조하면 부모 타입에 있는 멤버만 보임
        // -----------------------------
        // a1.fetch(); // 컴파일 에러

        // 다운캐스팅
        if (a1 instanceof Dog) {
            Dog downDog = (Dog) a1;
            downDog.fetch();
        }

        System.out.println();

        // -----------------------------
        // 6. 포함관계(has-a)
        // Car has-a Engine
        // -----------------------------
        Engine engine = new Engine(250);
        Car car = new Car("BMW", engine);
        car.drive();

        System.out.println();

        // -----------------------------
        // 7. 중첩 클래스
        // -----------------------------
        Car.CarUtils.printMaxSpeed();

        Car.Driver driver = car.new Driver();
        driver.introduce();

        System.out.println();

        // -----------------------------
        // 8. Object 메서드 예시
        // -----------------------------
        Object obj = dog; // 모든 객체는 Object로 받을 수 있음
        System.out.println(obj.toString());

        System.out.println();

        // -----------------------------
        // 9. final 지역 변수
        // 값 재할당 금지
        // -----------------------------
        final int year = 2026;
        System.out.println("현재 학습 연도: " + year);
        // year = 2027; // 에러
    }
}