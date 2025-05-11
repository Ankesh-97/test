package org.example;

import java.lang.management.ManagementFactory;

public class Main {
    public static void main(String[] args) {

        //System.out.println(ManagementFactory.getRuntimeMXBean());
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());

    }
}