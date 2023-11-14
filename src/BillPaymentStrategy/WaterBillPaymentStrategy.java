package BillPaymentStrategy;

import User.InstaPayUser;

public class WaterBillPaymentStrategy implements IBIllPaymentStrategy{

    @Override
    public void payBill(IBill bill, InstaPayUser instaPayUser) {
        System.out.println("Paying Water Bill of $" + bill.getAmount() + " for user: " + instaPayUser.getUsername());
        instaPayUser.getAccount().deductAmount(bill.getAmount());
        bill.markAsPaid();
    }
}
