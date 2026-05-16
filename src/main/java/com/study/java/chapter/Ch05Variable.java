package com.study.java.chapter;

/**
* Type conversion (casting)
* */
public class Ch05Variable {
    public static void main(String[] args) {
//        (타입)피연산자
        double d = 3.84;
        int score = (int)d; // d를 형변환 하는 것이 아니라 값을 형변환 (d는 변화 없음.)
        System.out.println("score = " + score); // 반올림 되지 않음!!!

//        값 손실이 없는 경우에만 자동으로 형변환 (작은 것 -> 큰 것)
//        정수간 형변환 (큰 거에서 작은 것으로 형변환을 하면 값 손실이 있을 수 있다.)
        int i = 300;
        System.out.println("300 to binary = " + Integer.toBinaryString(i));
        System.out.println("int 300 -> byte(8bit이므로 256(1|0000|000)은 손실되고 44(0010|1100)만 남음): " + (byte)i);
        float f = 8.1234567f;
        System.out.printf("f = %20.18f\n", f); // float은 근사값을 저장하므로 7자리만 정확하게 저장함.
        double d2 = 8.1234567;
        double d3 = (double) f;
//        d2와 d3는 값이 다름.
        System.out.printf("d2 = %20.18f\n", d2); // 정확
        System.out.printf("d3 = %20.18f\n", d3); // 오류
        
//        자주 사용하는 형변환
        System.out.println("숫자를 문자로 (char) (3 + '0') = " + (char) (3 + '0'));
        System.out.println("문자를 숫자로 ('3' - '0') = " + ('3' - '0'));
        System.out.println("숫자를 문자열로 (3 + \"\") = " + (3 + "") + ", Type: " + (3 + "").getClass().getSimpleName());
        System.out.println("문자열을 숫자로 Integer.parseInt(\"3\") = " + Integer.parseInt("3") + Integer.parseInt("3"));
        System.out.println("문자열을 숫자로 Double.parseDouble(\"3.14\") = " + Double.parseDouble("3.14"));
    }
}
