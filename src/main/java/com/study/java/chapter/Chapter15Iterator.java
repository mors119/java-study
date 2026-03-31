package com.study.java.chapter;

import java.util.*;

public class Chapter15Iterator {
    public static void main(String[] args) {

        // 모든 컬렉션은 Iterator로 순회 가능
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            String value = it.next();
            System.out.println(value);
        }

        /*
            for (String s : list)은 내부적으로는 아래와 같다.

            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String s = it.next();
            }
        */

        Map<String, String> map = new HashMap<>();
        map.put("A", "Apple");
        map.put("B", "Banana");

        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }


    }
}
