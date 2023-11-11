package User;

import Account.IAccount;

public class BankUser extends User {
    private String username;
    private String password;
    private String mobileNumber;
    private IAccount account;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public IAccount getAccount() {
        return account;
    }

    @Override
    public void signUp(User user) {

    }


    @Override
    public void signIn(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Bank user authenticated successfully.");
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }

    @Override
    public double inquireBalance() {
        return account.getBalance();
    }

    @Override
    public void payBills() {
        // Implement utility bill payment for BankUser
        System.out.println("BankUser paying bills.");
    }

    @Override
    public UserProfile viewProfile() {
        return new UserProfile(username, mobileNumber);
    }


}
