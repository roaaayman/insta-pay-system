package BillPaymentStrategy;

import Bill.IBill;
import User.InstaPayUser;

public interface IBIllPaymentStrategy {
    void payBill(IBill bill, InstaPayUser instaPayUser);

}
