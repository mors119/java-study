package com.study.java.example;

/**
 * 부모 클래스
 * - public: 다른 패키지에서도 접근 가능
 * - abstract는 아직 쓰지 않고, 일반 클래스로 유지
 */
public class Animal {

    // protected:
    // - 같은 패키지에서 접근 가능
    // - 다른 패키지라도 "자식 클래스"에서는 접근 가능
    protected String name;

    // private:
    // - 현재 클래스 내부에서만 접근 가능
    private int age;

    // static:
    // - 객체가 아니라 클래스 소속
    // - Animal 객체가 몇 개 생성되었는지 공용으로 관리
    private static int count = 0;

    /**
     * 기본 생성자
     */
    public Animal() {
        this("unknown", 0);
    }

    /**
     * 매개변수 생성자
     * super()의 반대편에서 부모 초기화에 사용됨
     *
     * @param name 동물 이름
     * @param age 동물 나이
     */
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    /**
     * public 메서드
     * 자식에서 오버라이딩 가능
     */
    public void speak() {
        System.out.println(name + "가 소리를 냅니다.");
    }

    /**
     * final 메서드
     * 자식이 오버라이딩 불가
     */
    public final void breathe() {
        System.out.println(name + "가 숨을 쉽니다.");
    }

    /**
     * getter
     * private 필드 age 접근용
     */
    public int getAge() {
        return age;
    }

    /**
     * static 메서드
     * 클래스 이름으로 호출
     */
    public static int getCount() {
        return count;
    }

    /**
     * Object 클래스의 toString() 오버라이딩
     * 모든 클래스는 결국 Object를 상속받음
     */
    @Override
    public String toString() {
        return "Animal{name='" + name + "', age=" + age + "}";
    }
}