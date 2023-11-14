package VerificationService;

import WalletUserData.Wallet;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WalletVerification implements IVerification{
    @Override
    public int sendOTP() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }


    @Override
    public boolean verifyOTP(String mobileNum) {
        int generatedOTP = sendOTP();

        System.out.println("YOUR OTP IS: "+generatedOTP);

        // Simulate user entering OTP (you can replace this with actual user input)
        System.out.print("Enter OTP sent to your mobile number: ");
        Scanner scanner = new Scanner(System.in);
        int userEnteredOTP = scanner.nextInt();

        // Verify OTP
        return generatedOTP == userEnteredOTP;
    }
    public boolean isWalletValid(String WalletProvider, String MobileNumber, List<Wallet> wallets) {
        for (Wallet wallet : wallets) {
            if (wallet.getWalletProvider().equalsIgnoreCase(WalletProvider) && wallet.getMobileNumber().equals(MobileNumber)) {
                return true; // Wallet details are valid
            }
        }
        return false; // Wallet details are not found in the list
    }
}
