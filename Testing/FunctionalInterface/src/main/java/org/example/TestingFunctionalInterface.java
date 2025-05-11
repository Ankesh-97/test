package org.example;

@FunctionalInterface
public interface TestingFunctionalInterface {

    void test();

    static void canBeCalled() {
        System.out.println("This is a static method");
    }
}
