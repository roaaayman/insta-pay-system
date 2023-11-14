package BillPaymentStrategy;

import User.User;

public class GasBillPaymentStrategy implements IBIllPaymentStrategy{

    @Override
    public void payBill(IBill bill, User user) {
        System.out.println("Paying Gas Bill of $" + bill.getAmount() + " for user: " + user.getUsername());
        user.getAccount().deductAmount(bill.getAmount());

        bill.markAsPaid();
    }
}
