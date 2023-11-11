package VerificationService;

import java.util.Random;
import java.util.Scanner;

public class BankVerification implements IVerification {
    @Override
    public int sendOTP() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);

    }

    @Override
    public boolean verifyOTP(String mobileNum) {
        int generatedOTP = sendOTP();
        System.out.println("YOUR OTP IS: "+generatedOTP);


        System.out.print("Enter OTP sent to your mobile number: ");
        Scanner scanner = new Scanner(System.in);
        int userEnteredOTP = scanner.nextInt();

        if (generatedOTP == userEnteredOTP) {
            System.out.println("System registered successfully");
        } else {
            System.out.println("OTP is wrong");
        }
        return generatedOTP == userEnteredOTP;
    }
}
