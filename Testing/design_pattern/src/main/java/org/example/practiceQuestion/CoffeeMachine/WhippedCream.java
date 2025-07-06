package org.example.practiceQuestion.CoffeeMachine;

public class WhippedCream extends CoffeeDecorators {
    protected WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return super.getDecorator().getPrice() + 10;
    }

    @Override
    public String getDescription() {
        return super.getDecorator().getDescription().concat(" WhippedCream");
    }
}
