package org.example.startegyDesignPattern.practiceQuestions.PaymentStartegy;

public class PurchaseHomeDecor extends PurchaseGood {

    public PurchaseHomeDecor(PaymentStrategy paymentStrategy) {
        super(paymentStrategy);
    }

    @Override
    public void purchase(int amount) {
        System.out.println("Purchasing home decor for amount: " + amount);
        super.purchase(amount);
    }
}
