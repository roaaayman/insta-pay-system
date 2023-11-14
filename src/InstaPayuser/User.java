package InstaPayuser;

import Account.IAccount;
import Bill.IBill;

import java.util.Scanner;

public abstract class User {
    private final IAccount account;
    private String username;
    private String password;

    // Add instance variables for enteredUsername and enteredPassword
    private String enteredUsername;
    private String enteredPassword;

    public User(String username, String password, IAccount account) {
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return account.getBalance();
    }

    public void signIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
         enteredUsername = scanner.nextLine();

        System.out.print("Enter your password: ");
         enteredPassword = scanner.nextLine();
    }

    public abstract void payBill(IBill bill);

    public IAccount getAccount() {
        return account;
    }

    // Implementation of isAuthenticated
    public boolean isAuthenticated() {
        // Use the enteredUsername and enteredPassword variables here
        return enteredUsername.equals(username) && enteredPassword.equals(password);
}
}