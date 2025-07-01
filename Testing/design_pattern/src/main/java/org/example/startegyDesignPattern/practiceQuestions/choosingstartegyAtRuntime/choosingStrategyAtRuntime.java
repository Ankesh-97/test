package src.design_patterns.startegyDesignPattern.practiceQuestions.choosingstartegyAtRuntime;

public class choosingStrategyAtRuntime {
    public static void main(String[] args) {

        //take user input
        String userInput = "A"; // Simulating user input for strategy choice
        Strategy strategy;
        if (userInput.equals("A")) {
            strategy = new ConcreteStrategyA();
        } else if (userInput.equals("B")) {
            strategy = new ConcreteStrategyB();
        } else {
            throw new IllegalArgumentException("Invalid strategy choice");
        }

        // Create a context with the chosen strategy
        Context context = new ConcreteContext(strategy);
        context.executeStrategy();

    }
}

interface Strategy {
    void execute();

    String getStrategyName();
}

class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy A");
    }

    @Override
    public String getStrategyName() {
        return "ConcreteStrategyA";
    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy B");
    }

    @Override
    public String getStrategyName() {
        return "ConcreteStrategyB";
    }
}

abstract class Context {
    protected Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        System.out.println("Current strategy: " + strategy.getStrategyName());
        strategy.execute();
    }
}

class ConcreteContext extends Context {
    public ConcreteContext(Strategy strategy) {
        super(strategy);
    }

    @Override
    public void executeStrategy() {
        System.out.println("Executing strategy in ConcreteContext");
        super.executeStrategy();
    }
}
