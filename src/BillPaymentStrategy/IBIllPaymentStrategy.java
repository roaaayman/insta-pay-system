package BillPaymentStrategy;

import User.User;

public interface IBIllPaymentStrategy {
    void payBill(IBill bill, User user);

}
