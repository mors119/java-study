package com.study.java.chapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Chapter13Set {
    public static void main(String[] args) {

        /*
            Set은 순서가 없으므로 get 할 수 없음.
            HashSet       → 순서 없음 (기본), 빠름
            LinkedHashSet → 입력 순서 유지, 약간 느림
            TreeSet       → 자동 정렬됨, 비교 기준 필요, 느림
         */
        Set<String> names = new HashSet<>();

        names.add("Kim");
        names.add("Lee");
        names.add("Park");
        names.add("Kim"); // 중복

        System.out.println("전체: " + names);
        System.out.println("개수: " + names.size());
        System.out.println("Kim 존재: " + names.contains("Kim"));

        names.remove("Lee");

        System.out.println("삭제 후: " + names);

        // 중복 제거
        List<String> list = List.of("A", "B", "A", "C");
        Set<String> set = new HashSet<>(list);
        List<String> setList = new ArrayList<>(new HashSet<>(list));

        System.out.println(set);
        System.out.println(setList);
    }
}
