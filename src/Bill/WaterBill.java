package Bill;

import User.User;
import User.WalletUser;

public class WaterBill implements IBill{
    private double amount;

    public WaterBill(double amount) {
        this.amount = amount;
    }

    @Override
    public void payBill(User user) {
        System.out.println("Paying Electricity Bill of $" + amount + " for user: " + user.getUsername());
        user.getAccount().deductAmount(amount);
    }
}
