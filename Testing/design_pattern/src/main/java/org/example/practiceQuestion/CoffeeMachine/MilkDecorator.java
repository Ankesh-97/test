package src.design_patterns.decorator_pattern.practiceQuestion.CoffeeMachine;

public class MilkDecorator extends CoffeeDecorators {
    protected MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getPrice() {
        return this.getDecorator().getPrice() + 10;
    }

    @Override
    public String getDescription() {
        return this.getDecorator().getDescription().concat(" Milk");
    }
}
