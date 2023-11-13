package BillPaymentStrategy;

import User.User;

public class WaterBill implements IBill {
    private double amount;
    private String accountNumber;
    private boolean paid = false;
    private IBIllPaymentStrategy paymentStrategy;

    public WaterBill(String accountNumber, double amount, IBIllPaymentStrategy paymentStrategy) {
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
    public void payBill(User user) {
        paymentStrategy.payBill(this, user);
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
