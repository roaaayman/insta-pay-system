package User;

import Account.IAccount;

public interface User {
    String getUsername(); // Abstract method declarations
    String getPassword();
    String getMobileNumber();
    IAccount getAccount();
    void signUp(String username, String password, String mobileNumber, IAccount account);
    void signIn(String username, String password);
    double inquireBalance();
    void payBills();
    UserProfile viewProfile();

    void displayAdditionalDetails();
}
