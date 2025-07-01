package src.design_patterns.startegyDesignPattern.practiceQuestions.PaymentStartegy;

public abstract class PurchaseGood {

    private final PaymentStrategy paymentStrategy;

    protected PurchaseGood(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void purchase(int amount) {
        this.paymentStrategy.pay(amount);
    }
}
