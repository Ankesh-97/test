package org.example.practiceQuestion.CoffeeMachine;

public class DriverClass {

    public static void main(String[] args) {
        Coffee coffee = new MilkDecorator(new SugarDecorator(new EspressoCoffee()));
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getPrice());
    }
}
