package BillPaymentStrategy;

import User.User;

public class ElectricityBillPaymentStrategy implements IBIllPaymentStrategy {

    @Override
    public void payBill(IBill bill, User user) {
        System.out.println("Paying Electricity Bill of $" + bill.getAmount() + " for user: " + user.getUsername());
        user.getAccount().deductAmount(bill.getAmount());
        bill.markAsPaid();
    }
}
