package BillPaymentStrategy;

import InstaPayuser.User;


public interface IBill {
    String getAccountNumber();
    double getAmount();
    public void payBill(User user) ;
    void markAsPaid();
    boolean isPaid();

}




