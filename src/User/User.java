package User;

import Account.IAccount;
import Bill.IBill;

import java.util.Scanner;

public abstract class User {
    private IAccount account;

    private String username;
    private String password;

    public User(String username, String password,IAccount account) {
        this.username = username;
        this.password = password;
        this.account=account;
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

    // Abstract sign-up method to be implemented by concrete subclasses
    public abstract void signUp();

    public void signIn(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("User authenticated successfully.");
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }

    public abstract void payBill(IBill bill);
    public IAccount getAccount() {
        return account;
    }



}
