package com.study.java.chapter;
/**
 * 연산자
* */
public class Ch06Operator {
    public static void main(String[] args) {
//    연산자는 반드시 하나의 결과를 반환
//    x + (+ = 연산자) 1
//        산술 연산자 + - * / % << >>
//        비교 연산자 > < >= <= == !=
//        논리 연산자 && || ! & | ^ ~
//        대입 연산자 = (lvalue = rvalue일 때 lvalue는 변수가 와야함.)
//        기타 연산자 (type) 타입변환,  ?: 삼항, instanceof instanceof 연산자

//        우선순위: 단항 연산(-x) > 괄호() 내부 > 곱셈 나눗셈 > 덧셈 뺄셈 > 쉬프트(<<, >>) > 비교 연산자 > 논리 연산자(비교보다 비트(논리)연산이 늦음!) > 대입 연산자

//        연산자 결합 규칙: 좌에서 우가 기본 / 대입 연산(x = y = 3)과 단항 연산(-x)의 경우 우측에서 좌측

//        산술 변환: 연산 시 발생하는 자동 형변환 (1. 두 연산의 타입을 일치 시킨다. 2. 타입이 int보다 작으면 int로 변환)
//        long + int -> long, float + int -> float, double + int -> double
//        ** byte + short -> int + int = int, char + short -> int + int = int
        System.out.println("5 / 2 = " + 5 / 2); // 2
        System.out.println("5 / 2 = " + 5 / (float) 2f); // 2.5


//        증감 연산자 ++ --
        int a = 1;
        System.out.println("a++ = " + a++); // 후위형: 값이 참조된 후에 증가
        System.out.println("++a = " + ++a); // 전위형: 값이 참조되기 전에 증가


//      사칙 연산자 + - * / %
        System.out.println("5 / 2 = " + 5 / 2); // 2
//        System.out.println("5 / 2 = " + 5 / 0); // 정수 0 나누기 - 오류
        System.out.println("5 / 2 = " + 5 / 0.0); // 실수 0.0 나누기 - Infinity (무한)
        byte b1 = 10;
        byte b2 = 20;
//        byte b3 = b1 + b2; 오류 발생
        byte b3 = (byte) (b1 + b2); // 연산 시 int로 바뀌므로 다시 형변환이 필요
        System.out.println("b3 = " + b3);

        int i1 = 10000000;
        int i2 = 2000000;
        long l1 = (long) i1 * i2; // 한쪽은 long으로 바꿔야 오버플로우를 막을 수 있음
        System.out.println("l1 = " + l1);

        char c1 = 'a';
//        char c2 = c1 + 1; char도 연산 시 int로 변환되므로 오류 발생
        char c2 = 'a' + 1; // 값이 변하지 않으므로 컴파일러가 미리 계산해서 컴파일 단계에서 값을 넣어둠.
//        또는
        char c3 = (char) (c1 + 1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("('c' - 'a')  = " + ('c' - 'a') ); // char가 int로 연산된다는 것을 알 수 있음.

//        소수점 아래 자르기
        double pi = 3.1415926535;
        float pif = (int) (pi * 1000) / 1000f; // 1000.0과 1000f 같음
        System.out.println("(int) (3.1415926535 * 1000) / 1000f = " + pif);
//        반올림은 Math.round 함수 사용
        System.out.println("Math.round(pi * 1000) / 1000f = " + Math.round(pi * 1000) / 1000.0);
        
//      비교 연산자 - 결과는 true / false
//      비교 연산자 자동 산술 변환
        System.out.println("10 == 10.0f" + (10 == 10.0f)); // 10.0f == 10.0f로 변환됨.
        System.out.println("('0' == 0) = " + ('0' == 0)); // 48 == 0, '0'은 48로 변환돼 비교됨.
//       double과 float을 비교할 때는 double을 float으로 변환 후 비교
        float f = 0.1f;
        double d = 0.1d;
        System.out.println("((double) f == d) = " + ((double) f == d)); // float은 근사값이므로 false가 나옴
        System.out.println("(f == (float) d) = " + (f == (float) d)); // true
        String str = "abc";
        System.out.println("str.equals(\"abc\") = " + str.equals("abc"));
        System.out.println("str.equalsIgnoreCase(\"ABC\") = " + str.equalsIgnoreCase("ABC")); // 대소문자 구분없이


//       논리 연산자 ||(or) &&(and)  = 두 조건을 연결할 때 사용
        System.out.println("true || false = " + (true || false));
        System.out.println("true && false = " + (true && false));
//      || && 식을 구성할 때 확률이 높은 것을 먼저(왼쪽에) 사용한다.
//      || 는 true 가능성이 높은 조건을 왼쪽
//       && 는 false 가능성이 높은 조건을 왼쪽
        int age = 25;
        if (age > 18 || expensiveCheck()) System.out.println("성인");

//        논리 연산자 ! = true/false를 토글
        boolean toggle = true;
        System.out.println("!!!toggle = " + !!!toggle);


//       비트 연산자 &(or) |(and) ^(xor) = 이진수 연산 (true = 1, false = 0)
//       비트연산 시에도 int형 32bit로 변환되어 계산, 산술 연산보다 성능 우수함.
        int x = 10; // 1010
        int y = 20; // 10100
        System.out.println("x & y = " + toBinary(x & y) + " (" + (x & y) + ")");
        System.out.println("x | y = " + toBinary(x | y) + " (" + (x | y) + ")");
        System.out.println("x ^ y = " + toBinary(x ^ y) + " (" + (x ^ y) + ")");
        System.out.println("~x    = " + Integer.toBinaryString(~x) + " (" + ~x + ")");

//      쉬프트 연산 >> << >>>
//        x << n 은 x * (2의 n 제곱)의 결과와 같다
//        x >> n 은 x / (2의 n 제곱)의 결과와 같다
        System.out.println("(8 << 1) = " + (8 << 1)); // 8 * 2의 1제곱과 결과가 같음


//      삼항 연산자 ? :
//      rs = (x > y) ? x : y 는 if (x > y) rs = x; else rs = y; 와 동일
        int rs = x > 0 ? 1 : (x == y ? 0 : -1);
        System.out.println("x > 0 ? 1 : (x == y ? 0 : -1) = " + rs);

//       복합 대입 연산
        y *= 10 + x; // y = 20 * (10 + 10)
        System.out.println("y *= 10 + x = " + y); // y = y * (10 + x)
    }

    static boolean expensiveCheck() {
        System.out.println("비싼 연산 수행");
        return true;
    }

    static String toBinary(int value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0');
    }
}
