package Bill;

import User.User;


public interface IBill {
    String getAccountNumber();
    double getAmount();
    void payBill(User user);
    boolean isPaid();

}




