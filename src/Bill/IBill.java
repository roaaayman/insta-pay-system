package Bill;

import User.InstaPayUser;


public interface IBill {
    String getAccountNumber();
    double getAmount();
    public void payBill(InstaPayUser instaPayUser) ;
    void markAsPaid();
    boolean isPaid();

}




