import Account.BankAccount;
import Account.InstapayAccount;
import Account.WalletAccount;
import BankDummydata.Bank;
import BankDummydata.DummyBankFactory;
import BillData.BankUserBills;
import BillData.WalletUserBills;
import BillPaymentStrategy.IBill;
import User.BankUser;
import User.BankUserController;
import User.BillPaymentService;
import User.WalletUser;
import WalletUserData.Wallet;
import WalletUserData.WalletDummyFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<BankUser> bankUsers = new ArrayList<>();
    private static List<WalletUser> walletUsers = new ArrayList<>();



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WalletAccount w = new WalletAccount();
        BankAccount b = new BankAccount();
        InstapayAccount i = new InstapayAccount();
        int billAmount;
        // Assuming you have a list of banks created by DummyBankFactory
        List<Bank> banks = DummyBankFactory.createBanks();
        List<Wallet> Wallets = WalletDummyFactory.createWallets();
        BankUserController bankUserController = new BankUserController();


        boolean exit = false;
        boolean exitinner=false;
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
                        bankUserController.signUpBankUser(banks,bankUser);
                        bankUsers.add(bankUser);
                        
                        break;
                    case 2:


                        if (!bankUsers.isEmpty()) {
                            System.out.println("Bank User Sign-In:");
                            bankUser.signIn();
                            if (bankUsers.contains(bankUser)) {
                                System.out.println("User authenticated successfully.");
                                bankUserController.displayAccountDetails(bankUser);
                                while (!exitinner) {
                                    System.out.println("Bank User Menu");
                                    System.out.println("1. Transfer to wallet Account");
                                    System.out.println("2. Transfer to Bank Account");
                                    System.out.println("3. Transfer to instapay Account");
                                    System.out.println("4. Deposit");
                                    System.out.println("5. Inquire about his balance");
                                    System.out.println("6. pay bills");
                                    System.out.println("7. Exit");

                                    System.out.print("Enter your choice: ");
                                    int bankChoice = scanner.nextInt();
                                    switch (bankChoice) {
                                        case 1:
                                            System.out.println("Enter the amount you want to transfer");
                                            amountToBeTransferred=scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Enter the wallet account number you want to transfer to");
                                            destinationAccountNumber=scanner.nextLine();
                                            b.transfer(w,amountToBeTransferred,destinationAccountNumber);
                                            break;
                                        case 2:
                                            System.out.println("Enter the amount you want to transfer");
                                            amountToBeTransferred=scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Enter the wallet account number you want to transfer to");
                                            destinationAccountNumber=scanner.nextLine();
                                            b.transfer(b,amountToBeTransferred,destinationAccountNumber);
                                            break;
                                        case 3:
                                            System.out.println("Enter the amount you want to transfer");
                                            amountToBeTransferred=scanner.nextInt();
                                            System.out.println("Enter the wallet account number you want to transfer to");
                                            destinationAccountNumber=scanner.nextLine();
                                            b.transfer(i,amountToBeTransferred,destinationAccountNumber);
                                            break;
                                        case 4:
                                            System.out.println("Enter the amount you want to deposit");
                                            amountToBeDeposited=scanner.nextInt();
                                            b.deposit(amountToBeDeposited);
                                            System.out.println("your new balance is $ "+bankUser.getBalance());
                                            break;
                                        case 5:
                                            System.out.println("Your current account balance is $ "+ bankUser.getBalance());
                                            break;
                                        case 6:
                                            List<IBill> bankbills = BankUserBills.initializeBills();
                                            BillPaymentService.chooseAndPayBill(bankbills,bankUser.getBalance(),bankUser.getBankAccount(),bankUser);
                                            break;
                                        case 7:

                                            exitinner=true;
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("Bank User authentication failed. Returning to Main Menu.");
                                System.out.println("----------------------------------");

                            }

                        } else {
                            System.out.println("No bank users signed up. Please sign up first.");
                            break;
                        }
                            // Check if sign-in was successful before entering the inner loop


                        break;
                    case 3:
                        walletUser = new WalletUser(null, null, null, null,w);
                        System.out.println("Wallet User Sign-Up:");
                        walletUser.signUp(Wallets);
                        break;
                    case 4:
                        if (walletUser != null) {
                            System.out.println("Wallet User Sign-In:");
                            walletUser.signIn();
                            walletUser.displayAccountDetails();

                            if (walletUsers.contains(walletUser)) {
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
                                        case 1:
                                            System.out.println("Enter the amount you want to transfer");
                                            amountToBeTransferred=scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Enter the wallet account number you want to transfer to");
                                            destinationAccountNumber=scanner.nextLine();
                                            w.transfer(w,amountToBeTransferred,destinationAccountNumber);
                                            break;
                                        case 2:
                                            //
                                            break;
                                        case 3:
                                            System.out.println("Enter the amount you want to deposit");
                                            amountToBeDeposited=scanner.nextInt();
                                            w.deposit(amountToBeDeposited);
                                            System.out.println("your new balance is $ "+walletUser.getBalance());
                                            break;
                                        case 4:
                                            System.out.println("Your current account balance is $ "+ walletUser.getBalance());
                                            break;
                                        case 5:
                                            List<IBill> walletbills = WalletUserBills.initializeBills();
                                            BillPaymentService.chooseAndPayBill(walletbills,walletUser.getBalance(),walletUser.getMobileNumber(),walletUser);
                                            break;
                                        case 6:

                                            break;

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