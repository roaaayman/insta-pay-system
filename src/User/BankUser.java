package User;

import java.util.Scanner;

public class BankUser extends User {
    private String bankName;
    private String bankAccount;

    public BankUser(String username, String password, String bankName) {
        super(username, password);
        this.bankName = bankName;
        this.bankAccount = null;
    }

    public String getBankName() {
        return bankName;
    }

    @Override
    public void signUp() {
        if (getUsername() == null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Signing up Bank user...");

            // Prompt the user for username
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            // Prompt the user for password
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            // Prompt the user for the bank name
            System.out.print("Enter Bank Name: ");
            bankName = scanner.nextLine();

            // Prompt the user for the bank account details as a string
            System.out.print("Enter Bank Account (as a string): ");
            bankAccount = scanner.nextLine();

            setUsername(username);
            setPassword(password);

            System.out.println("Username: " + getUsername());
            System.out.println("Password: " + getPassword());
            System.out.println("Bank Name: " + bankName);
            System.out.println("Bank Account: " + bankAccount);
            System.out.println("Bank user signed up successfully.");

            // Close the scanner
            scanner.close();
        } else {
            System.out.println("Bank user is already registered.");
        }
    }

    @Override
    public void displayAdditionalDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Type: Bank");
    }
}