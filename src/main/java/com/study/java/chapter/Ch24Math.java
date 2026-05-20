package com.study.java.chapter;

import java.util.ArrayList;

/**
 * AutoBoxing & Unboxing,
 * Math, wrapper,IEEEremainder, Exact
 */
public class Ch24Math {
    public static void main(String[] args) {
        // abs: 절대값
        System.out.println(Math.abs(-10)); // 10

        // ceil: 올림
        System.out.println(Math.ceil(10.1)); // 11.0

        // floor: 버림
        System.out.println(Math.floor(10.9)); // 10.0

        // round: 반올림 (소수점 첫째자리에서 반올림하여 long 반환)
        System.out.println(Math.round(10.5)); // 11

        // max, min: 최대, 최소값
        System.out.println(Math.max(10, 20)); // 20
        System.out.println(Math.min(10, 20)); // 10

        // random: 0.0 <= x < 1.0 사이의 임의의 double 반환
        System.out.println(Math.random());

        // rint: 가장 가까운 정수값을 double로 반환 (두 정수 가운데 있는 경우 짝수 반환)
        System.out.println(Math.rint(10.5)); // 10.0
        System.out.println(Math.rint(11.5)); // 12.0

        // IEEEremainder(x, y): x를 y로 나눈 뒤, 가장 가까운 정수 n에 대해 x - (y * n)을 반환한다.
        // 원형 데이터(각도, 시계, 시간)에서 "가장 가까운 차이"를 계산할 때 매우 유용
        double current = 350.0; // 현재 시침 방향
        double target = 10.0;   // 목표 방향
        double diff = Math.IEEEremainder(target - current, 360.0);
        System.out.println((target - current) % 360); // -340
        System.out.println(diff); // 20.0

        // sqrt: 제곱근
        System.out.println(Math.sqrt(9)); // 3.0

        // pow: 제곱
        System.out.println(Math.pow(2, 3)); // 8.0

        // 오버플로우가 발생하면 예외를 발생시키는 함수들
        // int addExact(int x, int y) // x + y
        // int subtractExact(int x, int y) // x - y
        // int multiplyExact(int x, int y) // x * y
        // int incrementExact(int a) // a++
        // int decrementExact(int a) // a--
        // int negateExact(int a) // -a
        // int toIntExact(long v) // (int) v == int로 형변환

        // Wrapper 클래스 (Boolean, Character, Byte, Short, Integer, Long, Float, Double)
        // 전부 valueOf로 형변환 가능 - 객체를 생성해서 방환(생성자 대신 사용 가능하고 객체 재사용(캐시) 가능)
        // Integer i = new Integer(10); // 생성자로 생성 (항상 새 객체 생성), 사용 중단 권장
        Integer i = Integer.valueOf(10); // 팩토리 메서드 (캐시 사용 가능).
        // Integer Cache - Integer 내부에서 관리하며 재사용성이 좋음.
        // 아래와 유사하게 작성되어 있음. 자주 사용하는 -128과 127을 미리 만들어 두고 범위에 포함되면 미리 만든 값을 넘겨줌.
        // public static Integer valueOf(int i) {
        //    if (i >= -128 && i <= 127) {
        //        return IntegerCache.cache[i + 128];
        //    }
        //    return new Integer(i);
        //}
        System.out.println(i == Integer.valueOf(10)); // true
        System.out.println(Integer.valueOf(200) == Integer.valueOf(200)); // 캐시 범위를 넘어가므로 false

        // Number 클래스: BigInteger, BigDecimal + Byte, Short, Integer, Long, Float, Double의 최상위 클래스

        // 오토박싱 & 언박싱: 기본형과 래퍼 클래스 간의 자동 변환
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); // 오토박싱, 10 -> Integer.valueOf(10)
        // list.add(Integer.valueOf(10)); // 오토 박싱이 안되면
        int value = list.get(0); // 오토 언박싱, Integer.valueOf(10) -> 10
        // int value = list.get(0).intValue(); // 오토 언박싱이 안되면
    }

}
