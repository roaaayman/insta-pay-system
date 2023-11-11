package Bill;


import User.User;

public class ElectricityBill implements IBill{
    private double amount;

    public ElectricityBill(double amount) {
        this.amount = amount;
    }


    @Override
    public void payBill(User user) {
        System.out.println("Paying Electricity Bill of $" + amount + " for user: " + user.getUsername());

    }
}
