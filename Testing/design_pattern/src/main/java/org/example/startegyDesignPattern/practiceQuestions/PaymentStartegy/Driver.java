package src.design_patterns.startegyDesignPattern.practiceQuestions.PaymentStartegy;

public class Driver {

    public static void main(String[] args) {
        PurchaseGood purchaseHomeDecor = new PurchaseHomeDecor(new CreditCardPaymentStrategy("38783", "John Doe", "12/25"));
        purchaseHomeDecor.purchase(1000);
    }
}
