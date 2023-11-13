package Bill;

import User.User;

public class WaterBill implements IBill {
    private double amount;
    private String accountNumber;

    public WaterBill(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
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
        System.out.println("Paying Gas Bill of $" + amount + " for user: " + user.getUsername());
        user.getAccount().deductAmount(amount);
    }
}
