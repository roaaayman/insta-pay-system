import Account.BankAccount;
import Account.IAccount;
import Account.WalletAccount;
import User.BankUser;
import User.WalletUser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IAccount w=new WalletAccount();
        IAccount b=new BankAccount();

        boolean exit = false;
        BankUser bankUser = null;
        WalletUser walletUser = null;

        while (!exit) {
            System.out.println("Main Menu");
            System.out.println("1. Sign up as Bank User");
            System.out.println("2. Sign in as Bank User");
            System.out.println("3. Sign up as Wallet User");
            System.out.println("4. Sign in as Wallet User");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String choiceStr = scanner.nextLine(); // Read the input as a string

            try {
                int choice = Integer.parseInt(choiceStr); // Parse the string as an integer

                switch (choice) {
                    case 1:
                        bankUser = new BankUser(null, null, null, null, null,b);
                        System.out.println("Bank User Sign-Up:");
                        bankUser.signUp();
                        break;
                    case 2:
                        if (bankUser != null) {
                            System.out.println("Bank User Sign-In:");
                            bankUser.signIn();
                        } else {
                            System.out.println("Bank User is not signed up.");
                        }
                        break;
                    case 3:
                        walletUser = new WalletUser(null, null, null,w);
                        System.out.println("Wallet User Sign-Up:");
                        walletUser.signUp();
                        break;
                    case 4:
                        if (walletUser != null) {
                            System.out.println("Wallet User Sign-In:");
                            walletUser.signIn();
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
