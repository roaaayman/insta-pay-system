package BillPaymentStrategy;

import User.InstaPayUser;

public class ElectricityBill implements IBill {
    private double amount;
    private String accountNumber;
    private boolean paid = false;
    private IBIllPaymentStrategy paymentStrategy;

    public ElectricityBill(String accountNumber, double amount, IBIllPaymentStrategy paymentStrategy) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void payBill(InstaPayUser instaPayUser) {
        paymentStrategy.payBill(this, instaPayUser);
    }

    @Override
    public boolean isPaid() {
        return paid;
    }

    @Override
    public void markAsPaid() {
        paid = true;
    }
}
