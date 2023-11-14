package User;

import Account.IAccount;
import BillPaymentStrategy.ElectricityBill;
import BillPaymentStrategy.GasBill;
import BillPaymentStrategy.IBill;
import BillPaymentStrategy.WaterBill;
import BillData.WalletUserBills;
import VerificationService.WalletVerification;
import WalletUserData.Wallet;

import java.util.ArrayList;
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
    public void setWalletProvider(String walletprovider) {
        WalletProvider=walletprovider;
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

            WalletVerification walletv = new WalletVerification();
            if (walletv.isWalletValid(WalletProvider, mobileNumber, Wallets)) {
                setUsername(username);
                setPassword(password);

                System.out.println("Account Available in Wallet provider "+WalletProvider);
                System.out.println("----------------------------------");
                loadDetails();


                boolean verified = walletv.verifyOTP(mobileNumber);
                if (verified) {

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

    public void loadDetails()
    {
        System.out.println("Wallet user signed up successfully.");
        System.out.println("----------------------------------");
        System.out.println("Your Profile");
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword());
        System.out.println("Wallet Provider Name: " + WalletProvider);
        System.out.println("Mobile Number associated with the wallet: " + mobileNumber);
    }



    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Mobile Number: " + getMobileNumber());
        System.out.println("Wallet Provider: " + getWalletProvider());
        System.out.println("Balance: $" + getBalance());
        if (bills != null) {
            BillPaymentService.checkBills(bills,getMobileNumber());
        } else {
            System.out.println("No bills available.");
        }
    }
}
