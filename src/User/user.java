package User;

import Account.IAccount;

public class user {
    private static String username;
    private String password;
    private static String mobileNumber;
    private IAccount account; // This represents the user's account (either BankAccount or WalletAccount)



    public static String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static String getMobileNumber() {
        return mobileNumber;
    }

    public IAccount getAccount() {
        return account;
    }

    public void signUp(String username, String password, String mobileNumber, IAccount account) {
        if (this.username != null) {
            System.out.println("User is already registered.");
            return;
        }
        // Perform user registration logic
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.account = account;

        System.out.println("User registered successfully.");
    }

    public void signIn(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("User authenticated successfully.");
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }
    //    public void transferToUser(User recipient, double amount) {
//        // Implement logic for transferring money to another user's account
//        // You can use the recipient's account to complete the transfer
//        // Ensure authentication, validation, and deduct the amount
//        if (this.account.transfer(recipient.getAccount(), amount)) {
//            System.out.println("Transfer successful.");
//        } else {
//            System.out.println("Transfer failed. Insufficient balance or other issues.");
//        }
//    }

    public double inquireBalance() {
        // You should implement logic to inquire about the user's account balance here
       /// return account.getBalance();
        return 0;
    }

    public void payBills() {
        // Implement utility bill payment for Gas, Electricity, and Water
    }

    public UserProfile viewProfile() {
        return new UserProfile(username, mobileNumber);
    }
}
