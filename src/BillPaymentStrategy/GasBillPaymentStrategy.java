package BillPaymentStrategy;

import Bill.IBill;
import User.InstaPayUser;

public class GasBillPaymentStrategy implements IBIllPaymentStrategy{

    @Override
    public void payBill(IBill bill, InstaPayUser instaPayUser) {
        System.out.println("Paying Gas Bill of $" + bill.getAmount() + " for user: " + instaPayUser.getUsername());
        instaPayUser.getAccount().deductAmount(bill.getAmount());
        bill.markAsPaid();
    }
}
