package src.design_patterns.observer_pattern.practiceQuestions.stocksmarket;


public class Stock {

    private String name;
    private String price;

    public Stock(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }
}
