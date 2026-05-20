package com.study.java.chapter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * String
 */
public class Ch22String {
    // 문자는 불변 객체 a += b 불가능
    public static void main(String[] args) throws UnsupportedEncodingException {
        // "abc"로 만든 문자열은 String contant pool에 올려서 같은 "abc"를 공유
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2); // true (같은 "abc" 주소를 가리킴)

        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str3 == str4); // false (따로 생성된 "abc"이기 때문에 주소 값이 다름)
        System.out.println(str3.equals(str4)); // true (문자도 객체이기 때문에 값을 비교할 때는 equals 사용 (내용 비교 시 equals))

        System.out.println("-------------------------------------");

        // 초기화 시 null 보다는 ""를 이용하는 게 좋다.
        String str5 = "";

        // 문자 배열로 생성
        char[] c = {'H', 'e', 'l', 'l', 'o'};
        String str6 = new String(c);
        // String str6 = c.toString();

        // 스트링 버퍼로 문자 생성
        StringBuffer sb = new StringBuffer("Hello");
        String str7 = new String(sb);
        // String str7 = sb.toString();

        // charAt: 해당 인덱스에 문자 찾기
        char c2 = str7.charAt(1); // 'e'
        System.out.println("c2 = " + c2);
        

        // compareTo: 사전 순으로 비교. 같으면 0, 빠르면 -1, 느리면 1
        int i1 = "aaa".compareTo("bbb"); // -1 (bbb에 비해 aaa는 빠름)
        System.out.println("i1 = " + i1);

        // concat: 문자열 더하기 ( "" + "" 와 같음)
        String str8 = str6.concat(str7); // "HelloHello"
        System.out.println("str8 = " + str8);

        // contains 지정된 문자열이 포함 되었는지 (charSequence를 받으므로 Stringbuffer, CharBuffer 등도 가능)
        boolean b1 = str8.contains("Hello"); // true
        System.out.println("b1 = " + b1);

        // endWith: 지정 문자열로 끝나는지 검사
        boolean b2 = str8.contains("aaa"); // false
        System.out.println("b2 = " + b2);

        // equalsIgnoreCase: 대소문자 구분 없이 일치하는지 여부 확인
        boolean b3 = str6.equalsIgnoreCase("Hello"); // true
        System.out.println("b3 = " + b3);

        // indent: 들여쓰기(이미 들여쓰기가 된 경우 - 음수 가능 - 0보다 작아질 수 없음.)
        // String str9 = str8.indent(-2); // "HelloHello"
        String str9 = str8.indent(2); // "  HelloHello"
        System.out.println("str9 = " + str9);
        String str10 = str9.indent(-1); // " HelloHello"
        System.out.println("str10 = " + str10);

        // indexOf: 있으면 그 문자열(문자)의 시작 인덱스 반환, 없으면 -1 반환
        int i2 = str10.indexOf("Hello"); // 1
        System.out.println("i2 = " + i2);
        int i3 = str10.indexOf('o'); // 5
        System.out.println("i3 = " + i3);
        int i4 = str10.indexOf("lo", i3); // 9, indexOf(문자, 찾기 시작할 위치)
        System.out.println("i4 = " + i4);

        // intern: new String으로 생성된 문자열을 상수풀(constant pool)에 추가 (이미 있는 경우 주소값 반환)
        String str11 = new String("cbd");
        String str12 = "cbd";
        System.out.println(str11 == str12); // false
        System.out.println(str11.intern() == str12.intern()); // true
        String str13 = str11.intern();
        System.out.println(str13 == str12); // true

        // lastIndexOf: 뒤부터 indexOf 진행 (char, String만 가능) - 시작 위치 지정 없음.
        System.out.println(str13.lastIndexOf('b')); // 1

        // length: 길이 반환 (""이 0, 있으면 1부터 진행)
        System.out.println(str13.length()); // 3
        
        // repeat: 같은 내용을 n번 반복한 문자열 반환 (jdk 21)
        System.out.println("*".repeat(5)); // "*****"

        // replace(old, new): (old, new)를 받아서 old를 new로 전체 교체 (CharSequence 받음)
        System.out.println(str10.replace("Hello", "Bye")); // " ByeBye"

        // replaceAll(정규식, 교체할 문자열): 정규식(| 일반문자)을 받아서 일치하는 것을 전체 교체
        String str14 = str10.replaceAll(" ", "Bye");
        System.out.println(str14); // ByeHelloHello

        // replaceFirst(정규식, 교체할 문자열): 일치하는 것중 처음으로 나오는 것만 교체
        System.out.println(str14.replaceFirst("Bye", "Hi")); // HiHelloHello

        // split(정규식 [, 지정된 수]): 지정된 분리자(문자, 정규 문자)로 [지정된 수 만큼] 나누어 배열로 반환
        String[] str15 = str14.split("H");
        System.out.println(Arrays.toString(str15)); // [Bye, ello, ello]
        String[] str16 = str14.split("H", 2);
        System.out.println(Arrays.toString(str16)); // [Bye, elloHello]

        // join: 여러 문자열을 구분자를 넣어 합침
        System.out.println(String.join(":", str15));

        // StringJoiner: (구분자 [, 접두사, 접미사])를 받아서 add로 합쳐줌
        StringJoiner sj = new StringJoiner("-", "[", "]");
        sj.add("a");
        sj.add("b");
        sj.add("c");
        System.out.println(sj); // [a-b-c]

        // startsWith: 주어진 문자열로 시작하는지 검사
        boolean b4 = str14.startsWith("By"); // true
        System.out.println(b4);

        // substring(시작 [, 끝]): 시작부터 끝 범위 내 문자열을 얻는다.
        String str17 = str14.substring(0, 6);
        System.out.println(str17); // ByeHel

        // toLowerCase: 소문자로 변경
        // toUpperCase: 대문자로 변경

        // trim: 양쪽 공백 제거
        // strip: 유니코드의 양쪽 공백도 제거 가능
        // stripLeading: 왼쪽 공백만 제거
        // stripTrailing: 우측 공백만 제거

        // valueOf: 다른 타입을 String 타입으로 변경 ( + ""와 같은 효과)
        System.out.println(String.valueOf(b1)); // "true"

        // 컴팩트 문자열: 메모리 절약을 위해 Latin-1인 경우 1byte로 저장 (jdk-9)
        String s1 = "AAA";
        String s2 = "가가가";
        System.out.println(Arrays.toString(s1.getBytes(StandardCharsets.UTF_8))); // [65, 65, 65]
        System.out.println(Arrays.toString(s2.getBytes(StandardCharsets.UTF_8))); // [-22, -80, -128, -22, -80, -128, -22, -80, -128]

        // getBytes: 문자열(String)을 특정 문자 인코딩(Character Encoding) 방식에 따라 바이트 배열(byte[])로 변환하는 메서드
        byte[] cp949_byte = "가".getBytes("CP949");
        System.out.println(Arrays.toString(cp949_byte)); // [-80, -95]
        String str18 = new String(cp949_byte,"CP949"); // throws UnsupportedEncodingException 필요
        System.out.println(str18); // "가"

        // format: 정해진 형식에 맞게 문자열을 생성해서 반환
        String str19 = String.format("%d 더하기 %d는 %d 입니다.", 1, 2, 1 + 2); // printf 형식과 동일
        System.out.println(str19);
        // formatted: 혁식에 값 넣기
        String str20 = "%d 더하기 %d는 %d 입니다.";
        System.out.println(str20.formatted(2, 3, 2 + 3));

    }

}
