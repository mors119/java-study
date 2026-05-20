package com.study.java.chapter;

/**
 * Object (equals, toString, clone(& 깊은 복사 구현), getClass)
 */
public class Ch21Object {
    // import문 생략 가능한 java.lang 패키지 - 기본적인
    // 객체 & 클래스: Object, Class, Package, Module ...
    // 래퍼 클래스(기본형 -> 참조형): Boolean, Byte, Integer, Long, Float, Double ...
    // 문자열 관련: String, StringBuffer, StringBuilder, CharSequence ...
    // 예외 관련: Throwable, Error, Exception, RuntimeException ...
    // 기타: Math, System, Thread, Enum, Record ...

    // Object class 모든 객체의 조상이다.

    // Object의 메서드
    // equals: 기본적으로 자신(this)과 obj 간 주소 비교
    static int ParNo = 0;
    static class Parson implements Cloneable {
        long id;
        int no = ParNo;
        int[] score;
        Parson(long id) {
            this.id = id;
            this.no = ParNo++;
            this.score = new int[]{10, 20};
        }
        // 다른 비교가 필요하면 override
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Parson p) {
                return id == p.id;
            }
            return false;
        }
        // toString() override
        @Override
        public String toString() {
            return "ID: " + id + ", NO: " + no;
        }
        // clone()을 사용 하려면,
        // 1. Cloneable 인터페이스를 구현해야 함 ( class implements Cloneable )
        // 2. clone() 메서드를 public으로 재정의(override)해야 함
        // 욥션 3-1. 자손 타입으로 변경 가능 (Person) 리턴 가능 - 사용부에서 형변환 없이 사용 가능
        // 옵션 3-2. 접근제어자 protected가 기본이지만 public으로 변경 가능
        @Override
        public Parson clone() { // 얕은 복사
            try {
//               return super.clone(); // public Object clone()이라면
                return (Parson) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
        // 깊은 복사
        public Parson deepCopy() {
            Parson copid = this.clone();
            // 참조 타입 필드를 새로 복사해야 깊은 복사
            copid.score = this.score.clone();

            return copid;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // Object - (Parent 에서 override 된) equals 메서드
        Parson p = new Parson(12);
        Parson p2 = new Parson(12);
        System.out.println(p.equals(p2)); // true

        // Object - hashcode 메서드 (32bit 값이라 중복이 발생할 수 있음.)
        String s1 = new String("abc");
        String s2 = new String("abc");
        // 내용으로 hashcode 생성 (내용이 같으므로 같음.)
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        // 주소로 hashcode 생성 (둘이 다름.)
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));

        // Object - toString: 객체를 문자열로 표현해서 반환
        System.out.println(s1); // abc, 객체 print 는 문자열로 바꾸므로 생략 가능
        System.out.println(s2.toString()); // abc
        // override 된 toString 사용
        System.out.println(p.toString()); // ID: 12, NO: 0
        System.out.println(p2.toString()); // ID: 12, NO: 1

        // Object - clone: 자신을 복사한 새로운 객체를 반환(얕은 복사)
        Parson p3 = p.clone();
        System.out.println(p.score == p3.score); // true
        // 깊은 복사
        Parson p4 = p2.deepCopy();
        System.out.println(p2.score == p4.score); // false

        // Object - getClass(): 클래스 정보 반환 (이런 정보로 객체를 생성하거나 비교할 수 있음.)
        System.out.println(p.getClass());
        System.out.println(p.getClass().getName());
        System.out.println(Class.forName("com.study.java.chapter.Ch21Object")); // ClassNotFoundException 얘외 처리해줘야함.
    }
}
