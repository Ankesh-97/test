package org.example.practiceQuestion.CoffeeMachine;

public abstract class CoffeeDecorators implements Coffee {

    private Coffee coffee;

    protected CoffeeDecorators(Coffee coffee) {
        this.coffee = coffee;
    }

    protected final Coffee getDecorator() {
        return this.coffee;
    }
}
