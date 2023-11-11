package Bill;


import User.User;

public class GasBill implements IBill{
    private double amount;

    public GasBill(double amount) {
        this.amount = amount;
    }

    @Override
    public void payBill(User user) {
        System.out.println("Paying Gas Bill of $" + amount + " for user: " + user.getUsername());
        user.getAccount().deductAmount(amount);
    }
}
