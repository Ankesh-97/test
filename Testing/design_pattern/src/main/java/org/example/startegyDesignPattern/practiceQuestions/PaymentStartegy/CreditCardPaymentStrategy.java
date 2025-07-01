package src.design_patterns.startegyDesignPattern.practiceQuestions.PaymentStartegy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;

    public CreditCardPaymentStrategy(String cardNumber, String cardHolderName, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}
