package User;

import Account.IAccount;

public abstract class User {
    private String username;
    private String password;
    private String mobileNumber;
    private IAccount account;
    String getUsername()
    {
        return username;
    }
    // Abstract method declarations
    String getPassword()
    {
        return password;
    }
    String getMobileNumber()
    {
        return mobileNumber;
    }
    IAccount getAccount()
    {
        return account;
    }
    abstract void signUp(User user);

    void signIn(String username, String password)
    {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Bank user authenticated successfully.");
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }
    double inquireBalance()
    {
        return account.getBalance();
    }
    void payBills()
    {
        // Implement utility bill payment for BankUser
        System.out.println("BankUser paying bills.");
    }
    UserProfile viewProfile()
    {
        return new UserProfile(username, mobileNumber);
    }


}
