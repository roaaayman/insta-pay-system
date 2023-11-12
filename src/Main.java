import Account.BankAccount;
import Account.InstapayAccount;
import Account.WalletAccount;
import User.BankUser;
import User.WalletUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WalletAccount w = new WalletAccount();
        BankAccount b = new BankAccount();
        InstapayAccount i = new InstapayAccount();
        int billAmount;

        boolean exit = false;
        BankUser bankUser = null;
        WalletUser walletUser = null;
        int amountToBeTransferred;
        int amountToBeDeposited;
        String destinationAccountNumber;

        while (!exit) {
            System.out.println("Main Menu");
            System.out.println("1. Sign up as Bank User");
            System.out.println("2. Sign in as Bank User");
            System.out.println("3. Sign up as Wallet User");
            System.out.println("4. Sign in as Wallet User");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String choiceStr = scanner.nextLine();

            try {
                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1:
                        bankUser = new BankUser(null, null, null, null, null, b);
                        System.out.println("Bank User Sign-Up:");
                        bankUser.signUp();
                        break;
                    case 2:
                        if (bankUser != null) {
                            System.out.println("Bank User Sign-In:");
                            bankUser.signIn();

                            // Check if sign-in was successful before entering the inner loop
                            if (bankUser.isAuthenticated()) {
                                while (!exit) {
                                    System.out.println("Bank User Menu");
                                    System.out.println("1. Transfer to wallet Account");
                                    System.out.println("2. Transfer to Bank Account");
                                    System.out.println("3. Transfer to instapay Account");
                                    System.out.println("4. Deposit");
                                    System.out.println("5. Inquire about his balance");
                                    System.out.println("6. Pay bill");
                                    System.out.println("7. Exit");
                                    System.out.print("Enter your choice: ");
                                    int bankChoice = scanner.nextInt();
                                    switch (bankChoice) {
                                        // ... (existing code)
                                    }
                                }
                            } else {
                                System.out.println("Bank User authentication failed. Returning to Main Menu.");
                            }
                        } else {
                            System.out.println("Bank User is not signed up.");
                        }
                        break;
                    case 3:
                        walletUser = new WalletUser(null, null, null, w);
                        System.out.println("Wallet User Sign-Up:");
                        walletUser.signUp();
                        break;
                    case 4:
                        if (walletUser != null) {
                            System.out.println("Wallet User Sign-In:");
                            walletUser.signIn();

                            // Check if sign-in was successful before entering the inner loop
                            if (walletUser.isAuthenticated()) {
                                while (!exit) {
                                    System.out.println("Wallet User Menu");
                                    System.out.println("1. Transfer to wallet Account");
                                    System.out.println("2. Transfer to instapay Account");
                                    System.out.println("3. Deposit");
                                    System.out.println("4. Inquire about his balance");
                                    System.out.println("5. Pay bill");
                                    System.out.println("6. Exit");
                                    System.out.print("Enter your choice: ");
                                    int walletChoice = scanner.nextInt();
                                    switch (walletChoice) {
                                        // ... (existing code)
                                    }
                                }
                            } else {
                                System.out.println("Wallet User authentication failed. Returning to Main Menu.");
                            }
                        } else {
                            System.out.println("Wallet User is not signed up.");
                        }
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
