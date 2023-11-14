package BillPaymentStrategy;

import User.User;

public class ElectricityBillPaymentStrategy implements IBIllPaymentStrategy {

    @Override
    public void payBill(IBill bill, User user) {
        System.out.println("Paying Electricity Bill of $" + bill.getAmount() + " for user: " + user.getUsername());
        System.out.println(user.getAccount().getBalance());
        user.getAccount().deductAmount(bill.getAmount());
        System.out.println(user.getAccount().getBalance());

        bill.markAsPaid();
    }
}
