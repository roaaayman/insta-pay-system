package User;

import BankDummydata.Bank;
import VerificationService.BankVerificationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankUserController {
    private static List<BankInstaPayUser> signedUpUsers = new ArrayList<>();

    public void signUpBankUser(List<Bank> banks, BankInstaPayUser bankUser) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Signing up Bank user...");

        if (bankUser.getUsername() == null) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            System.out.print("Enter Bank Name: ");
            String bankName = scanner.nextLine();

            System.out.print("Enter Bank Account (as a string): ");
            String bankAccount = scanner.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobileNumber = scanner.nextLine();

            BankVerificationStrategy bankv = new BankVerificationStrategy();

            if (bankv.isBankValid(bankName, bankAccount, banks)) {
                bankUser.setUsername(username);
                bankUser.setPassword(password);
                bankUser.setBankName(bankName);
                bankUser.setBankAccount(bankAccount);
                bankUser.setMobileNumber(mobileNumber);

                System.out.println("Account Available in bank " + bankName);
                System.out.println("----------------------------------");

                boolean verified = bankv.verifyOTP(mobileNumber);
                if (verified) {
                    System.out.println("Bank user signed up successfully.");
                    System.out.println("----------------------------------");
                    System.out.println("Your Profile");

                    System.out.println("Username: " + bankUser.getUsername());
                    System.out.println("Password: " + bankUser.getPassword());
                    System.out.println("Bank Name: " + bankUser.getBankName());
                    System.out.println("Bank Account: " + bankUser.getBankAccount());
                    System.out.println("Mobile Number: " + bankUser.getMobileNumber());
                    System.out.println("----------------------------------");

                    signedUpUsers.add(bankUser);
                } else {
                    System.out.println("OTP verification failed. Bank user not signed up.");
                }
            } else {
                System.out.println("Invalid bank details. Bank user not signed up.");
            }
        } else {
            System.out.println("Bank user is already registered.");
        }
    }

    public void displayAccountDetails(BankInstaPayUser user) {
        System.out.println("Account Details:");
        System.out.println("Bank Name: " + user.getBankName());
        System.out.println("Bank Account: " + user.getBankAccount());
        System.out.println("Mobile Number: " + user.getMobileNumber());
        System.out.println("Balance: $" + user.getBalance());

        // Additional logic for displaying bills if needed
    }
}
