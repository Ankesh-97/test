package org.example.practiceQuestion.CoffeeMachine;

public class EspressoCoffee implements Coffee {
    @Override
    public double getPrice() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "Your coffee has Espresso";
    }
}
