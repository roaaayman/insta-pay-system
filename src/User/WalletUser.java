package User;

import Account.IAccount;
import Bill.IBill;
import Dummy.Bank;
import VerificationService.BankVerification;
import VerificationService.WalletVerification;
import WalletUserData.Wallet;

import java.util.List;
import java.util.Scanner;

public class WalletUser extends User {
    private String mobileNumber;


    public WalletUser(String username, String password, String mobileNumber, String WalletProvider,IAccount Account) {
        super(username, password,Account);
        this.mobileNumber = mobileNumber;
    }

    public double getBalance(){
        return getAccount().getBalance();
    }

    public String getMobileNumber() {
        return mobileNumber;
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
            String WalletProvider = scanner.nextLine();

            if (isWalletValid(WalletProvider, mobileNumber, Wallets)) {
                setUsername(username);
                setPassword(password);

                System.out.println("Username: " + getUsername());
                System.out.println("Password: " + getPassword());
                System.out.println("Wallet Provider Name: " + WalletProvider);
                System.out.println("Mobile Number associated with the wallet: " + mobileNumber);
                WalletVerification walletv = new WalletVerification();
                boolean verified = walletv.verifyOTP(mobileNumber);
                if (verified) {
                    System.out.println("Wallet user signed up successfully.");
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
                return true; // Bank details are valid
            }
        }
        return false; // Bank details are not found in the list
    }

    @Override
    public void payBill(IBill bill) {
        // Implement bill payment logic for wallet user
        bill.payBill(this);
    }


}