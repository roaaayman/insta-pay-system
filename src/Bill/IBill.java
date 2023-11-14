package Bill;

import InstaPayuser.User;


public interface IBill {
    String getAccountNumber();
    double getAmount();
    void payBill(User user);
    boolean isPaid();

}




