package User;

import BillData.WalletUserBills;
import BillPaymentStrategy.BillPaymentService;
import Bill.IBill;
import VerificationService.WalletVerificationStrategy;

import WalletUserData.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WalletUserController {
    WalletInstaPayUser walletuser;
    private static List<WalletInstaPayUser> signedUpUsers = new ArrayList<>();

    public void setWalletinfo(WalletInstaPayUser wallet, String username, String password, String mobilenumber, String walletPRovider)
    {
        walletuser=wallet;
        walletuser.setPassword(password);
        walletuser.setUsername(username);
        walletuser.setMobileNumber(mobilenumber);
        walletuser.setWalletProvider(walletPRovider);
    }
    List<IBill> bills = WalletUserBills.initializeBills();
    public void signUp(List<Wallet> Wallets, WalletInstaPayUser walletuser) {
        if (walletuser.getUsername() == null) {
            promptUserForDetails(walletuser);

            WalletVerificationStrategy walletv = new WalletVerificationStrategy();
            if (walletv.isWalletValid(walletuser.getWalletProvider(), walletuser.getMobileNumber(),Wallets)) {
                walletuser.setUsername(walletuser.getUsername());
                walletuser.setPassword(walletuser.getPassword());

                System.out.println("Account Available in Wallet provider " + walletuser.getWalletProvider());
                System.out.println("----------------------------------");
                loadDetails();
                signedUpUsers.add(walletuser);

                boolean verified = walletv.verifyOTP(walletuser.getMobileNumber());
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
    private void promptUserForDetails( WalletInstaPayUser walletuser) {
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
        String mobileNumber = scanner.nextLine();

        System.out.print("Enter Wallet Provider: ");
        String WalletProvider = scanner.nextLine();

        setWalletinfo(walletuser,username,password,mobileNumber,WalletProvider);

    }


    public void loadDetails()
    {
        System.out.println("Wallet user signed up successfully.");
        System.out.println("----------------------------------");
        System.out.println("Your Profile");
        System.out.println("Username: " + walletuser.getUsername());
        System.out.println("Password: " + walletuser.getPassword());
        System.out.println("Wallet Provider Name: " + walletuser.getWalletProvider());
        System.out.println("Mobile Number associated with the wallet: " + walletuser.getMobileNumber());
    }




    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Mobile Number: " + walletuser.getMobileNumber());
        System.out.println("Wallet Provider: " + walletuser.getWalletProvider());
        System.out.println("Balance: $" + walletuser.getBalance());
        if (bills != null) {
            BillPaymentService.checkBills(bills,walletuser.getMobileNumber());
        } else {
            System.out.println("No bills available.");
        }
    }

}