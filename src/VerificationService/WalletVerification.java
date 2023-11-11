package VerificationService;

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

        // Simulate user entering OTP (you can replace this with actual user input)
        System.out.print("Enter OTP sent to your mobile number: ");
        Scanner scanner = new Scanner(System.in);
        int userEnteredOTP = scanner.nextInt();

        // Verify OTP
        return generatedOTP == userEnteredOTP;
    }
}
