package User;

import Account.IAccount;
import Bill.IBill;

import java.util.Scanner;

public abstract class User {
    private final IAccount account;

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
    //display profile function
    public void displayProfile() {
        System.out.println("User Profile:");
        System.out.println("Username: " + username);
        // Add more information as needed
        account.displayAccountDetails();
    }

    public void signIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();

        // Perform the sign-in logic here, for example:
        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            System.out.println("User authenticated successfully.");
            // Display user profile after successful sign-in
            displayProfile();
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }

        // Close the scanner

    }
    public double getBalance(){
        return account.getBalance();
    }



    public abstract void payBill(IBill bill);
    public IAccount getAccount() {
        return account;
    }



}
