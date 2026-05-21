package com.study.java.chapter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 유용한 util 클래스
 */
public class Ch25UsefullClass {
    // Objects: Object와 관련된 util 메서드 제공. 메서드 내부에서 null 체크
    class TestObjects {
        String name;

        // Objects.requireNonNull: null체크와 예외처리를 한 줄로
        void setName(String name) {
            // if(name == null) throw new NullPointerException("name must not be null.");
            // this.name = name;
            // 위 코드를 Objects requireNonNull로 변경할 수 있다.
            this.name = Objects.requireNonNull(name,"name must not be null."); // String 또는 boolean 값을 리턴함.
        }

        // Objects.equals: null 체크와 동시에 값 비교
        boolean equalsAB(String a, String b) {
            // if(a != null && a.equals(b)) {}
            if(Objects.equals(a,b)) { return true; } // 값만 비교 하면 된다.
            return false;
        }
    }
    // java.util.Random: 난수를 사용할 때 사용, 멀티 스레드는 ThreadLocalRandom 사용!
    static class TestUtilRandom {
        // double randNum = Math.random(); // 0.0 <= x < 1.0 사이 난수 생성 (내부적으로는 new Random() 사용됨.)
        double randNum = new Random().nextDouble();

        // int num = (int) (Math.random() * 6) + 1; // 1 ~ 6 사이 정수
        int num = new Random().nextInt(6) + 1; //  1 ~ 6 사이 정수 nextInt(6) = O ~ 5

        // 멀티 스레드인 경우
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomInt = random.nextInt();
    }

    // java.util.regex: 정규식 관련 유틸
    class TestRegex {
        // Pattern: 정규식을 정의, Matcher: 대상 문자열과 정규식을 비교
        // 1. Pattern 객체 생성 (컴파일)
        // 2. Matcher 객체 생성 (비교 대상 입력)
        // 3. matches() 또는 find()로 결과 확인
        void regexExample() {
            String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date"};
            java.util.regex.Pattern p = java.util.regex.Pattern.compile("c[a-z]*"); // c로 시작하는 소문자 영단어

            for (String x : data) {
                java.util.regex.Matcher m = p.matcher(x);
                if (m.matches()) {
                    System.out.print(x + ", "); // ca, co, car, combat, count,
                }
            }
        }
    }

    // java.util.Scanner: 입력
    // java.util.StringTokenizer: 긴 문자열을 구분자를 기준으로 자를 때 사용
    class TestStringTokenizer {
        String expression = "x=100*(200+300)/2";

        void tokenize() {
            StringTokenizer st = new StringTokenizer(expression, "+-*=/()", true);
            while(st.hasMoreTokens()) {
                System.out.println(st.nextToken());
            }
        }

        // String[] rs = "100,200,300".split(",");
        // 아래와 동일
        Scanner rs2 = new Scanner("100,200,300").useDelimiter(",");

        // StringTokenizer와 동일
        String[] rs3 = expression.splitWithDelimiters("[=+\\-*/()]", expression.length()); // jdk 21
    }

    // java.math.BigInteger: long보다 큰 정수를 다룸. 불변 객체
    // java.math.BigDecimal: 아주 큰 실수를 오차없이 정확한 값으로 저장(내부엔 int[]로 저장됨.)
    class TestBigNum {
        BigInteger val;
        BigDecimal decimal;
        // 값 넣기
        TestBigNum() {
            // val = new BigInteger("1000123923840913840");
            val = BigInteger.valueOf(1231243111L);

            // decimal = new BigDecimal("123.456"); // 값을 넣을 때는 double 대신 문자열로 넣어서 오차를 완벽하게 없앨 수 있다.
            // decimal = BigDecimal.valueOf("123.456"); // 불가능 Long으로 변경해서 넣어야함.
            decimal = BigDecimal.valueOf(Long.parseLong("123.456"));
        }

        // 연산 메서드
        void bigNum() {
            val.add((BigInteger.valueOf(1231243111L))); // 덧셈
            val.subtract(BigInteger.valueOf(1231243111L)); // 뺄셈
            val.multiply(BigInteger.valueOf(1231243111L)); // 곱셈
            val.divide(BigInteger.valueOf(1231243111L)); // 나눗셈
            val.remainder(BigInteger.valueOf(1231243111L)); // 나머지 %
        }
    }


    public static void main(String[] args) {
        TestUtilRandom tr = new TestUtilRandom();
        System.out.println(tr.randNum);
        System.out.println(tr.num);


    }
}
