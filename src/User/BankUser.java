package User;

import Bill.IBill;
import VerificationService.BankVerification;

import java.util.Scanner;

public class BankUser extends User {
    private String bankName;
    private String bankAccount;
    private String mobileNumber;

    public BankUser(String username, String password, String bankName, String bankAccount, String mobileNumber) {
        super(username, password);
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.mobileNumber = mobileNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }


    @Override
    public void signUp() {
        if (getUsername() == null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Signing up Bank user...");

            // Prompt the user for username
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            // Prompt the user for password
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            // Prompt the user for the bank name
            System.out.print("Enter Bank Name: ");
            bankName = scanner.nextLine();

            // Prompt the user for the bank account details as a string
            System.out.print("Enter Bank Account (as a string): ");
            bankAccount = scanner.nextLine();

            // Prompt the user for the mobile number
            System.out.print("Enter Mobile Number: ");
            mobileNumber = scanner.nextLine();

            setUsername(username);
            setPassword(password);

            System.out.println("Username: " + getUsername());
            System.out.println("Password: " + getPassword());
            System.out.println("Bank Name: " + bankName);
            System.out.println("Bank Account: " + bankAccount);
            System.out.println("Mobile Number: " + mobileNumber);
            BankVerification bankv=new BankVerification();
            boolean verified = bankv.verifyOTP(mobileNumber);
            if (verified) {
                System.out.println("Bank user signed up successfully.");
            } else {
                System.out.println("OTP verification failed. Bank user not signed up.");
            }

            // Close the scanner
            scanner.close();
        } else {
            System.out.println("Bank user is already registered.");
        }
    }
}
