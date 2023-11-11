package User;

import Account.IAccount;

public abstract class User {
    String getUsername();
    // Abstract method declarations
    String getPassword();
    String getMobileNumber();
    IAccount getAccount();
    abstract void signUp(User user);

    void signIn(String username, String password);
    double inquireBalance();
    void payBills();
    UserProfile viewProfile();

    void displayAdditionalDetails();
}
