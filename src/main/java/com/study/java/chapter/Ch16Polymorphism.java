package com.study.java.chapter;

/**
 * 다형성, instanceof
 */
public class Ch16Polymorphism {
    // 다형성: 참조 변수 하나로 여러 종류의 객체를 다루기
    static class Tv {
        boolean power;
        void power() { power = !power; }
        void method() {
            System.out.println("Tv method");
        }
    }
    static class ColorTv extends Tv {
        String color;
        void color(String color) { this.color = color; }
        void method() {
            System.out.println("ColorTv method");
        }
    }

    void print(Tv tv) {
        if(tv instanceof ColorTv) { // ColorTv로 형변환 해도 되는지 확인
            ColorTv colorTv = (ColorTv) tv;
            colorTv.color("red");
        }
        if(tv instanceof ColorTv ct) { // ColorTv로 형변환 해도 되는지 확인하고 형변환 (jdk16 이후)
            ct.color("red");
        }
        if(tv instanceof ColorTv ct && "red".equals(ct.color)) { // &&로 조건 연결 가능 (|| 사용 불가)
            // ||는 앞 조건이 false일 때도 뒤를 검사해야 하므로 ct가 존재한다고 보장할 수 없음.
            System.out.println("red");
        }

        // switch문으로 instanceof 처리 가능 (jdk 21)
        switch (tv) {
            case null -> System.out.println("NULL"); // null 처리 가능

            case ColorTv ct when ct.color != null && ct.color.isEmpty() -> System.out.println("ColorTV color is empty");
            case ColorTv ct when ct.color != null && ct.color.isBlank() -> System.out.println("ColorTV color is blank");
            case ColorTv ct -> System.out.println("ColorTv");
            // case ColorTv ct -> {if(ct.color != null && ct.color.isEmpty()) {} if (ct.color != null && ct.color.isBlank() {}} 와 동일
            case Tv t -> System.out.println("TV");
//            default -> System.out.println("default");
        }
    }

    class OldTv extends Tv {}
    class NewTv extends Tv {}

    // 장점1. 참조형 매개 변수에 자신과 자손 타입의 객체 대입 가능
    void buy (Tv t) {
        // 장점2. 하나의 배열에 다양한 타입의 객체 대입 가능
        Tv[] tvCart = new Tv[2];
        tvCart[0] = new OldTv();
        tvCart[1] = new NewTv();
    }

    public static void main(String[] args) {
        Tv tv = new ColorTv();
        ColorTv colorTv = new ColorTv();
        // 다형성으로 선언하면 Tv의 것은 사용할 수 있지만 ColorTv의 것은 사용할 수 없음.
        // 자식이 가진게 더 많으므로
        // tv.color("test"); 사용 불가능
        colorTv.color("test");
        tv.method(); // 참조변수와 상관없이 [부모 자식 모두에 있는 메서드]는 항상 자식 메서드 호출
        colorTv.method();

        // 형변환
        ColorTv colorTv1 = (ColorTv) tv; // 다운캐스팅 (형변환 생략 불가능)
        Tv tv1 = colorTv; // 업캐스팅
        colorTv1.color("test");
        // tv1.color("test"); 사용 불가능
    }
}
