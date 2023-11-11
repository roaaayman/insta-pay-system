package User;

import Account.IAccount;

public class WalletUser extends User {
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
    void signUp(User user) {

    }


    @Override
    public void signIn(String username, String password) {
        // Implement wallet user sign-in logic
    }

    @Override
    public double inquireBalance() {
        // Implement wallet user balance inquiry logic
        return account.getBalance();
    }

    @Override
    public void payBills() {
        // Implement wallet user bill payment logic
    }

    @Override
    public UserProfile viewProfile() {
        return new UserProfile(username, mobileNumber);
    }



}
