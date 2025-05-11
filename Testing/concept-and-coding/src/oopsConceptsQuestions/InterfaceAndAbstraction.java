package oopsConceptsQuestions;

public class InterfaceAndAbstraction {
    public static void main(String[] args) {

    }
}

abstract class Animal{

    private String name;
    private int age;
    private String color;

    public abstract void eat();
    public abstract void sleep();
}

interface Flyable{
    void fly();
}

class Bird extends Animal implements Flyable, Runnable{

    @Override
    public void eat() {
        System.out.println("Bird is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Bird is sleeping");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }

    @Override
    public void run() {
        System.out.println("Bird is running");
    }
}


