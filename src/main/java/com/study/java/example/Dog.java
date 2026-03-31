package com.study.java.example;

/**
 * Dog is-a Animal
 * -> 상속 관계
 *
 * Java는 단일 상속만 허용:
 * class Dog extends Animal, AnotherClass // 불가능
 */
public class Dog extends Animal {

    private String breed;

    /**
     * super():
     * 부모 생성자 호출
     *
     * @param name  이름
     * @param age   나이
     * @param breed 품종
     */
    public Dog(String name, int age, String breed) {
        super(name, age); // 부모의 name, age 초기화
        this.breed = breed;
    }

    /**
     * 부모 메서드 오버라이딩
     */
    @Override
    public void speak() {
        // super.speak() : 부모 메서드 호출
        super.speak();
        System.out.println(name + "가 멍멍 짖습니다.");
    }

    public void fetch() {
        System.out.println(name + "가 공을 물어옵니다.");
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "', age=" + getAge() + ", breed='" + breed + "'}";
    }
}