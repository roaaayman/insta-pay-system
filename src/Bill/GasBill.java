package Bill;


import User.User;

public class GasBill implements IBill{
    private double amount;

    public GasBill(double amount) {
        this.amount = amount;
    }

    @Override
    public void payBill(User user) {
        System.out.println("Paying Gas bill for user: " + user.getUsername() + " - Amount: " + amount);
        // Implement the logic to deduct the bill amount from the user's account
    }
}
