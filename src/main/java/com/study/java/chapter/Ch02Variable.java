package com.study.java.chapter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
* Type
*/
public class Ch02Variable {
    /**
     * 코드 정렬 opt + cmd + L
     */
    public static void main(String[] args) {
        // var: jdk 10 이후 (타입 추론)
        var year = 10; // 타입이 길다면 var를 이용할 수 있다.
        // int year = 2024;
        // var map = new LinkedHashMap<>();처럼 긴 경우 좋다.
//      변수의 이름
//      1. 변수 이름은 대소문자 구분되며 길이 제한 없음.
//      2. 예약어 금지. (문맥 예약어도 안쓰는게 좋음)
//      3. 숫자로 시작해서는 안됨.
//      4. 특수문자는 '_'와 '$'만 허용됨.

//      변수의 타입
//      * 기본형(자바가 제공, 8개): 실제 값을 저장
//      boolean(true/false, 1byte), char(1개 문자, 2byte, 유니코드가 2byte 범위를 넘으면 2byte를 더해서 4byte에 저장 (써로 게이트 페어)),
//      byte(이진 데이터, 1byte), short(2byte), int(정수 기본, 4byte), long(8byte), float(4byte), double(실수 기본, 8byte)

        boolean b = true; // 소문자!!! true/false
        System.out.println("boolean = " + b);

        char ch1 = '가'; // '
        // char ch2 = ''; 빈 문자 불가능
        char ch3 = ' '; // 공백 가능
        char ch4 = 65; // 문자 코드 가능 ('A'와 동일)
        char ch5 = 0xAC00; // 유니코드 가능 ('가'와 동일) 자바는 utf-16을 기준으로 2byte 이내로 표현되어야 직접 대입 가능
        // char ch5_2 = 0xEAB080; // utf-8 (2byte 넘는 값은 대입 불가 -> 오류 발생)
        char ch6 = '\t'; // 변수에 tab 저장
        System.out.println("char = " + ch1);
        System.out.println("공백 = [" + ch3 + "]");
        System.out.println("65 = " + ch4);
        System.out.println("0xAC00 = " + ch5);
        System.out.println("ch6 = " + ch6);
        // tab = '\t', backspace = '\b', form feed = '\f', new line = '\n', carriage return = '\r',
        // 역슬래쉬(\) = '\\', 작은 따옴표(') = '\'', 큰 따옴표(") = '\"', 유니코드 = '\ u유니코드번호'

        byte by = 123; // 1byte
        System.out.println("byte = " + by);
        short s = 30_000; // 2byte
        System.out.println("short = " + s);
        int i = 2_000_000_000; // [기본], 4byte
        System.out.println("int = " + i);
        long l = 2_000_000_000_000L; // 8byte, 숫자 뒤에 접미사 L, 전체 40억개 (부호 있는 경우 -20억 ~ 20억, 없는 경우 정수 40억)
        System.out.println("long = " + l);
        BigInteger bi = BigInteger.valueOf(2_000_000_000_000_000L); // 무한한 크기 (int 배열 형태)
        // BigInteger bi = new BigInteger(2_000_000_000_000_000L + ""); // long은 직접 받을 수 없어서 + ""로 String으로 전달
        System.out.println("BigInteger = " + bi);

        float f = 3.14f; // 접미사 f, 7자리
        System.out.println("float = " + f);
        double d = 3.141592; // [기본], 접미사 d 사용 가능 (3.141592d), 15자리
        System.out.println("double = " + d);
        BigDecimal bigDecimal1 = new BigDecimal("3.1415926535897932384626433832795"); // 무제한 실수 받기
        // 또는 BigDecimal bigDecimal2 = BigDecimal.valueOf(3.1415926535897932384626433832795); // 메서드 사용해서 직접 받기
        System.out.println("BigDecimal = " + bigDecimal1);


//      참조형(직접 만들 수 있음.): 객체의 주소를 저장 한다.
        String str = "Hello"; // "
        System.out.println("str = " + str);
        String str2 = ""; // 빈 문자 가능

    }
}
