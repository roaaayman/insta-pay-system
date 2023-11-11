package User;

import Bill.IBill;

import java.util.Scanner;

public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public void signIn() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();

        // Perform the sign-in logic here, for example:
        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            System.out.println("User authenticated successfully.");
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }

        // Close the scanner

    }



    public abstract void payBill(IBill bill);



}
