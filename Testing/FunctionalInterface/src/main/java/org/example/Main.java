package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10);

        Stream<Integer> stream = list.stream().map(i ->i*-1)
                .peek(e->System.out.println("After Filter "+e)).sorted((i1, i2) -> i2 - i1)
                .peek(e->System.out.println("After map "+e)).filter(i -> i % 2 == 0)
                .peek(e->System.out.println("After Sort "+e)).toList().stream();
        System.out.println(stream.toList());
    }
}