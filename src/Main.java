import Account.*;

import BankDummydata.Bank;
import BankDummydata.DummyBankFactory;
import Bill.ElectricityBill;
import Bill.GasBill;
import Bill.WaterBill;
import BillData.BankUserBills;
import BillData.WalletUserBills;
import BillPaymentStrategy.BillPaymentService;
import Bill.IBill;
import Transferral.ITransferStrategy;
import Transferral.TransferToBank;
import Transferral.TransferToWallet;
import User.*;
import WalletUserData.Wallet;
import WalletUserData.WalletDummyFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<BankInstaPayUser> bankUsers = new ArrayList<>();
    private static List<WalletInstaPayUser> walletUsers = new ArrayList<>();




    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WalletAccount w = new WalletAccount();
        BankAccount b = new BankAccount();
        ITransferStrategy transfertobank=new TransferToBank();
        ITransferStrategy transfertoWallet=new TransferToWallet();

        int billAmount;
        // Assuming you have a list of banks created by DummyBankFactory
        List<Bank> banks = DummyBankFactory.createBanks();
        List<Wallet> Wallets = WalletDummyFactory.createWallets();
        BankUserController bankUserController = new BankUserController();
        WalletUserController walletUserController=new WalletUserController();


        boolean exit = false;
        boolean exitinner=false;
        boolean exitinner2=false;
        BankInstaPayUser bankUser = null;
        WalletInstaPayUser walletUser = null;
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
                        bankUser = new BankInstaPayUser(null, null, null, null, null, b);
                        System.out.println("Bank User Sign-Up:");
                        bankUserController.signUpBankUser(banks,bankUser);
                        bankUsers.add(bankUser);
                        
                        break;
                    case 2:


                        if (!bankUsers.isEmpty()) {
                            System.out.println("Bank User Sign-In:");
                            bankUser.signIn();
                            System.out.println("----------------------------------");

                            if (bankUsers.contains(bankUser)) {
                                System.out.println("User authenticated successfully.");
                                bankUserController.displayAccountDetails(bankUser);
                                while (!exitinner) {
                                    System.out.println("Bank User Menu");
                                    System.out.println("1. Transfer to wallet Account");
                                    System.out.println("2. Transfer to Bank Account");
                                    System.out.println("3. Deposit");
                                    System.out.println("4. Inquire about his balance");
                                    System.out.println("5. pay bills");
                                    System.out.println("6. Exit");

                                    System.out.print("Enter your choice: ");
                                    int bankChoice = scanner.nextInt();
                                    switch (bankChoice) {
                                        case 1:
                                            System.out.println("Enter the amount you want to transfer");
                                            amountToBeTransferred=scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Enter the wallet account number you want to transfer to");
                                            destinationAccountNumber=scanner.nextLine();
                                            transfertoWallet.transfer(b,w,amountToBeTransferred,destinationAccountNumber);
                                            break;
                                        case 2:
                                            System.out.println("Enter the amount you want to transfer");
                                            amountToBeTransferred=scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Enter the bank account number you want to transfer to");
                                            destinationAccountNumber=scanner.nextLine();
                                            transfertobank.transfer(b,b,amountToBeTransferred,destinationAccountNumber);
                                            break;

                                        case 3:
                                            System.out.println("Enter the amount you want to deposit");
                                            amountToBeDeposited=scanner.nextInt();
                                            b.deposit(amountToBeDeposited);
                                            System.out.println("your new balance is $ "+bankUser.getBalance());
                                            break;
                                        case 4:
                                            System.out.println("Your current account balance is $ "+ bankUser.getBalance());
                                            break;
                                        case 5: // Choosing to pay bills
                                            List<IBill> bankbills = BankUserBills.initializeBills();
                                            List<IBill> userBills = BillPaymentService.checkBills(bankbills, bankUser.getBankAccount());
                                            BillPaymentService.chooseAndPayBill(userBills, bankUser.getBalance(), bankUser.getBankAccount(), bankUser);

                                            break;

                                        case 6:

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
                        walletUser = new WalletInstaPayUser(null, null, null, null,w);
                        System.out.println("Wallet User Sign-Up:");
                        walletUserController.signUp(Wallets,walletUser);
                        walletUsers.add(walletUser);

                        break;
                    case 4:

                            System.out.println("Wallet User Sign-In:");
                            walletUser.signIn();
                            walletUserController.displayAccountDetails();
                        System.out.println("----------------------------------");

                        if (walletUsers.contains(walletUser)) {
                                while (!exitinner2) {
                                    System.out.println("Wallet User Menu");
                                    System.out.println("1. Transfer to wallet Account");
                                    System.out.println("2. Deposit");
                                    System.out.println("3. Inquire about his balance");
                                    System.out.println("4. Pay bill");
                                    System.out.println("5. Exit");
                                    System.out.print("Enter your choice: ");
                                    int walletChoice = scanner.nextInt();
                                    switch (walletChoice) {
                                        case 1:
                                            System.out.println("Enter the amount you want to transfer");
                                            amountToBeTransferred=scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.println("Enter the wallet account number you want to transfer to");
                                            destinationAccountNumber=scanner.nextLine();
                                            transfertoWallet.transfer(w,w,amountToBeTransferred,destinationAccountNumber);
                                            break;

                                        case 2:
                                            System.out.println("Enter the amount you want to deposit");
                                            amountToBeDeposited=scanner.nextInt();
                                            w.deposit(amountToBeDeposited);
                                            System.out.println("your new balance is $ "+walletUser.getBalance());
                                            break;
                                        case 3:
                                            System.out.println("Your current account balance is $ "+ walletUser.getBalance());
                                            break;
                                        case 4:
                                            List<IBill> walletbills = WalletUserBills.initializeBills();
                                            List<IBill> userBills = BillPaymentService.checkBills(walletbills, walletUser.getMobileNumber());
                                            BillPaymentService.chooseAndPayBill(userBills,walletUser.getBalance(),walletUser.getMobileNumber(),walletUser);
                                            break;
                                        case 5:
                                            exitinner2=true;
                                            break;
                                            

                                    }
                                }
                            } else {
                                System.out.println("Wallet User authentication failed. Returning to Main Menu.");
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