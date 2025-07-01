package src.design_patterns.decorator_pattern.practiceQuestion.CoffeeMachine;

public class DriverClass {

    public static void main(String[] args) {
        Coffee coffee = new MilkDecorator(new SugarDecorator(new EspressoCoffee()));
        System.out.println(coffee.getDescription());
        System.out.println(coffee.getPrice());
    }
}
