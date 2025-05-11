package oopsConceptsQuestions;

public class AbstractionAndEncapsulation {
    public static void main(String[] args) {

    }
}

enum AccountType {
    SAVINGS, CURRENT
}

abstract class BankAccount{
    private double accountBalance;
    private AccountType accountType;
    private double interestRate;

    public BankAccount(AccountType accountType,double accountBalance, double interestRate) {
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.interestRate = interestRate;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double withdraw(double amount) {
        if (amount > accountBalance) {
            System.out.println("Insufficient balance");
            return 0;
        }
        accountBalance -= amount;
        return amount;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    protected abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(double interestRate, double accountBalance) {
        super(AccountType.SAVINGS, accountBalance, interestRate);
    }

    @Override
    public double calculateInterest() {
        return 0;
    }
}
