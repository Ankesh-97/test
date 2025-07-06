package org.example.practiceQuestion.CoffeeMachine;

public class SugarDecorator extends CoffeeDecorators {
    protected SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return super.getDecorator().getPrice() + 10;
    }

    @Override
    public String getDescription() {
        return super.getDecorator().getDescription().concat(" Sugar");
    }
}
