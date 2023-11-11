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
        // Implement water bill payment logic
        System.out.println("Paying Water Bill of $" + amount + " for user: " + user.getUsername());
        // Implement deduction from user's account balance or any other logic
    }
}
