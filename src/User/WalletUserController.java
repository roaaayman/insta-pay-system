package User;

import Account.IAccount;
import Account.WalletAccount;
import BillData.WalletUserBills;
import BillPaymentStrategy.IBill;
import VerificationService.WalletVerification;
import WalletUserData.Wallet;

import java.util.List;
import java.util.Scanner;

public class WalletUserController {
    WalletUser walletuser;
    public void setWalletinfo(WalletUser wallet,String username,String password, String mobilenumber,String walletPRovider)
    {
        walletuser=wallet;
        walletuser.setPassword(password);
        walletuser.setUsername(username);
        walletuser.setMobileNumber(mobilenumber);
        walletuser.setWalletProvider(walletPRovider);
    }
    List<IBill> bills = WalletUserBills.initializeBills();
    public void signUp(List<Wallet> Wallets,WalletUser walletuser) {
        if (walletuser.getUsername() == null) {
            WalletVerification walletv = new WalletVerification();
            if (walletv.isWalletValid(walletuser.getWalletProvider(), walletuser.getMobileNumber(),Wallets)) {
                walletuser.setUsername(walletuser.getUsername());
                walletuser.setPassword(walletuser.getPassword());

                System.out.println("Account Available in Wallet provider " + walletuser.getWalletProvider());
                System.out.println("----------------------------------");
                loadDetails();

                boolean verified = walletv.verifyOTP(walletuser.getMobileNumber());
                if (verified) {
                    // Further processing if needed
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
        System.out.println("Username: " + walletuser.getUsername());
        System.out.println("Password: " + walletuser.getPassword());
        System.out.println("Wallet Provider Name: " + walletuser.getWalletProvider());
        System.out.println("Mobile Number associated with the wallet: " + walletuser.getMobileNumber());
    }

    private static WalletUser createWalletUser(String username, String password, String mobileNumber, String walletProvider) {
        // You can customize the creation of the WalletUser instance here, for example, using a factory
        IAccount walletAccount = new WalletAccount(); // Replace with your logic to create a wallet account
        return new WalletUser(username, password, mobileNumber, walletProvider, walletAccount);
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
