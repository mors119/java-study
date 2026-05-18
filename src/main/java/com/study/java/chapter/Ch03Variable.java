package com.study.java.chapter;
/**
 * Constant, Text
* */
public class Ch03Variable {
    public static void main(String[] args) {
        // 변수 = 하나의 값을 저장
        int year = 2026;

        // 상수 = 값을 한번만 저장
        final int MAX_VALUE = 100;
        // MAX_VALUE = 200; 오류

        // 리터럴 = 그 자체로 값을 의미 (2026, 100 모두 리터럴)

        // 문자열 결합 (다른 타입도 문자열과 결합되면 문자열이 됨.)
        System.out.printf("i1 + i1 + str = %s\n", 7 + 7 + ""); // "14"
        System.out.printf("str + i1 + i1 = %s\n", "" + 7 + 7); // "77"

        // -------------------------
        // 텍스트 블럭 (jdk 15 이상)
        String str2 = """
                public static void main(String[] args) {
                    System.out.println("Hello");
                }
                """;
        System.out.println("str2 = " + str2);

        // 위와 동일 (낮은 버전에서 가능)
        String str3 = "public static void main(String[] args) {\n"
                + "System.out.println(\"Hello\");\n"
                + "}";
        System.out.println("str3 = " + str3);
    }
}
