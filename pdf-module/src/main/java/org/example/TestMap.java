package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMap {
    public static void main(String[] args) {

        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        number.add(3);

        Map<String,Integer> map = number.stream().map(num-> Map.entry("key"+num,num)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(map);
    }
}
