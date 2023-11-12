import Account.BankAccount;
import Account.IAccount;
import Account.InstapayAccount;
import Account.WalletAccount;
import Bill.ElectricityBill;
import Bill.GasBill;
import Bill.IBill;
import User.BankUser;
import User.WalletUser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WalletAccount w=new WalletAccount();
        BankAccount b=new BankAccount();
        InstapayAccount i=new InstapayAccount();
        int billAmount;




        boolean exit = false;
        BankUser bankUser = null;
        WalletUser walletUser = null;
        int amountTobeTransferred;
        int amountTobeDeposited;

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
                            while(!exit)
                            {
                                System.out.println("Bank User Menu");
                                System.out.println("1. Transfer to wallet Account");
                                System.out.println("2. Transfer to Bank Account");
                                System.out.println("3. Transfer to instapay Account");
                                System.out.println("4. Deposit");
                                System.out.println("5. Inquire about his balance");
                                System.out.println("6. Pay bill");
                                System.out.println("7. Exit");
                                System.out.print("Enter your choice: ");
                                int bankchoice = scanner.nextInt();
                                switch (bankchoice)
                                {
                                    case 1:
                                        System.out.println("Enter the amount you want to transfer");
                                        amountTobeTransferred=scanner.nextInt();
                                        b.transfer(w,amountTobeTransferred);
                                        break;
                                    case 2:
                                        System.out.println("Enter the amount you want to transfer");
                                        amountTobeTransferred=scanner.nextInt();
                                        b.transfer(b,amountTobeTransferred);
                                        break;
                                    case 3:
                                        System.out.println("Enter the amount you want to transfer");
                                        amountTobeTransferred=scanner.nextInt();
                                        b.transfer(i,amountTobeTransferred);
                                        break;
                                    case 4:
                                        System.out.println("Enter the amount you want to deposit");
                                        amountTobeDeposited=scanner.nextInt();
                                        b.deposit(amountTobeDeposited);
                                        break;
                                    case 5:
                                        break;
                                    case 6:
                                        //showing bills
                                        System.out.print("Enter bill type (Gas/Electricity/Water): ");
                                        String billType = scanner.nextLine();
                                        if(billType=="Gas")
                                        {
                                            //GasBill gas=new GasBill(billAmount);
                                            //bankUser.payBill(gas);
                                        }
                                        else if(billType=="Electricity")
                                        {
                                            //ElectricityBill electric=new ElectricityBill(billAmount);
                                            //bankUser.payBill(Electricity);
                                        }
                                        else if(billType=="water")
                                        {
                                            //WaterBill water=new WaterBill(billAmount);
                                            //bankUser.payBill(water);
                                        }
                                        break;
                                    case 7:
                                        exit=true;
                                        break;

                                }



                            }
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
                            while(!exit)
                            {
                                System.out.println("Wallet User Menu");
                                System.out.println("1. Transfer to wallet Account");
                                System.out.println("2. Transfer to instapay Account");
                                System.out.println("3. Deposit");
                                System.out.println("4. Inquire about his balance");
                                System.out.println("5. Pay bill");
                                System.out.println("6. Exit");
                                System.out.print("Enter your choice: ");
                                int bankchoice = scanner.nextInt();
                                switch (bankchoice)
                                {
                                    case 1:
                                        System.out.println("Enter the amount you want to transfer");
                                        amountTobeTransferred=scanner.nextInt();
                                        w.transfer(w,amountTobeTransferred);
                                        break;
                                    case 2:
                                        System.out.println("Enter the amount you want to transfer");
                                        amountTobeTransferred=scanner.nextInt();
                                        w.transfer(i,amountTobeTransferred);
                                        break;
                                    case 3:
                                        System.out.println("Enter the amount you want to deposit");
                                        amountTobeDeposited=scanner.nextInt();
                                        w.deposit(amountTobeDeposited);
                                        break;
                                    case 4:
                                        break;
                                    case 5:
                                        //showing bills
                                        System.out.print("Enter bill type (Gas/Electricity/Water): ");
                                        String billType = scanner.nextLine();
                                        if(billType=="Gas")
                                        {
                                            //GasBill gas=new GasBill(billAmount);
                                            //bankUser.payBill(gas);
                                        }
                                        else if(billType=="Electricity")
                                        {
                                            //ElectricityBill electric=new ElectricityBill(billAmount);
                                            //walletUser.payBill(Electricity);
                                        }
                                        else if(billType=="water")
                                        {
                                            //WaterBill water=new WaterBill(billAmount);
                                            //walletUser.payBill(water);
                                        }
                                        break;
                                    case 7:
                                        exit=true;
                                        break;

                                }



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
