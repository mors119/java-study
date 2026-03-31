package com.study.java.chapter;

import java.util.HashMap;
import java.util.Map;

public class Chapter14Map {
    public static void main(String[] args) {

        Map<String, String> fruits = new HashMap<>();

        fruits.put("A", "Apple");
        fruits.put("B", "Banana");
        fruits.put("C", "Cherry");

        System.out.println("전체: " + fruits);
        System.out.println("A: " + fruits.get("A"));
        System.out.println("Size: " + fruits.size());
        System.out.println("A 존재: " + fruits.containsKey("A"));

        fruits.put("A", "Avocado");

        System.out.println("수정 후 A: " + fruits.get("A"));

        fruits.remove("B");

        System.out.println("삭제 후: " + fruits);

        // key, value 반복
        for (Map.Entry<String, String> entry : fruits.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // key, value 반복
        for (String key : fruits.keySet()) {
            System.out.println(key + " → " + fruits.get(key));
        }

        // value 반복
        for (String value : fruits.values()) {
            System.out.println(value);
        }

        Map<String, Integer> countMap = new HashMap<>();

        String[] arr = {"A", "B", "A"};

        // 카운팅 패턴
        for (String s : arr) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
    }
}
