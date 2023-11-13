package User;

import Account.IAccount;
import Bill.ElectricityBill;
import Bill.GasBill;
import Bill.IBill;
import Bill.WaterBill;
import BillData.BankUserBills;
import BillData.WalletUserBills;
import VerificationService.WalletVerification;
import WalletUserData.Wallet;

import java.util.List;
import java.util.Scanner;

public class WalletUser extends User {
    private String mobileNumber;
    private String WalletProvider;
    List<IBill> bills = WalletUserBills.initializeBills();


    public WalletUser(String username, String password, String mobileNumber, String WalletProvider, IAccount Account) {
        super(username, password, Account);
        this.mobileNumber = mobileNumber;
    }

    public double getBalance() {
        return getAccount().getBalance();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getWalletProvider() {
        return WalletProvider;
    }
    public void setWalletProvider(String Walletprovider) {
        Walletprovider=Walletprovider;
    }


    public void setMobileNumber(String mobnum) {
        mobileNumber=mobnum;
    }

    public void signUp(List<Wallet> Wallets) {
        if (getUsername() == null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Signing up Wallet user...");

            // Prompt the user for username
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            // Prompt the user for password
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            // Prompt the user for the mobile number
            System.out.print("Enter Mobile Number: ");
            mobileNumber = scanner.nextLine();

            System.out.print("Enter Wallet Provider: ");
             WalletProvider = scanner.nextLine();
            setUsername(username);
            setPassword(password);
            setWalletProvider(WalletProvider);
            setMobileNumber(mobileNumber);

            if (isWalletValid(WalletProvider, mobileNumber, Wallets)) {
                setUsername(username);
                setPassword(password);

                System.out.println("Account Available in Wallet provider "+WalletProvider);
                System.out.println("----------------------------------");



                WalletVerification walletv = new WalletVerification();
                boolean verified = walletv.verifyOTP(mobileNumber);
                if (verified) {
                    System.out.println("Wallet user signed up successfully.");
                    System.out.println("----------------------------------");
                    System.out.println("Your Profile");
                    System.out.println("Username: " + getUsername());
                    System.out.println("Password: " + getPassword());
                    System.out.println("Wallet Provider Name: " + WalletProvider);
                    System.out.println("Mobile Number associated with the wallet: " + mobileNumber);
                } else {
                    System.out.println("OTP verification failed. Wallet user not signed up.");
                }
            } else {
                System.out.println("Invalid Wallet details. Wallet user not signed up.");
            }

        } else {
            System.out.println("Wallet user is already registered.");
        }
    }

    private boolean isWalletValid(String WalletProvider, String MobileNumber, List<Wallet> wallets) {
        for (Wallet wallet : wallets) {
            if (wallet.getWalletProvider().equalsIgnoreCase(WalletProvider) && wallet.getMobileNumber().equals(MobileNumber)) {
                return true; // Wallet details are valid
            }
        }
        return false; // Wallet details are not found in the list
    }
    public void checkBills(List<IBill> bills) {
        for (IBill bill : bills) {
            if (bill.getAccountNumber().equals(mobileNumber)) {
                if (bill instanceof GasBill) {
                    System.out.println("You have a Gas bill with amount $" + bill.getAmount());
                } else if (bill instanceof WaterBill) {
                    System.out.println("You have a Water bill with amount $" + bill.getAmount());
                } else if (bill instanceof ElectricityBill) {
                    System.out.println("You have an Electricity bill with amount $" + bill.getAmount());
                } else {
                    System.out.println("You have a bill with amount $" + bill.getAmount());
                }
            }
        }
    }

    @Override
    public void payBill(IBill bill) {
        // Implement bill payment logic for wallet user
        bill.payBill(this);
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Wallet Provider: " + ((Wallet) getAccount()).getWalletProvider());
        System.out.println("Balance: $" + getBalance());
        if (bills != null) {
            checkBills(bills);
        } else {
            System.out.println("No bills available.");
        }
    }
}
