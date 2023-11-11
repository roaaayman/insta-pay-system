package User;

import Account.IAccount;

public class BankUser implements User {
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


    public void signUp(String username, String password, String mobileNumber, IAccount account) {
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.account = account;
        System.out.println("Bank user registered successfully.");
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

    @Override
    public void displayAdditionalDetails() {
        System.out.println("Account Type: Bank");
        // Include any additional details specific to BankUser here
    }
}
