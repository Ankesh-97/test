package io.dummy.service;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Driver {
    public static void main(String[] args) {

        String a = new String("a");
        String b = new String("a");

        System.out.println(a==b);
        System.out.println(a.equals(b));




    }
}
