package User;

import BankDummydata.Bank;
import VerificationService.BankVerification;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankUserController {
    private static List<BankUser> signedUpUsers = new ArrayList<>();

    public void signUpBankUser(List<Bank> banks, BankUser bankUser) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Signing up Bank user...");

        if (bankUser.getUsername() == null) {
            getUserDetails(scanner, bankUser);

            BankVerification bankv = new BankVerification();
            if (bankv.isBankValid(bankUser.getBankName(), bankUser.getBankAccount(), banks)) {
                boolean verified = bankv.verifyOTP(bankUser.getMobileNumber());
                if (verified) {
                    displayUserInformation(bankUser);
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

    private void getUserDetails(Scanner scanner, BankUser bankUser) {
        System.out.print("Enter Username: ");
        bankUser.setUsername(scanner.nextLine());

        System.out.print("Enter Password: ");
        bankUser.setPassword(scanner.nextLine());

        System.out.print("Enter Bank Name: ");
        bankUser.setBankName(scanner.nextLine());

        System.out.print("Enter Bank Account (as a string): ");
        bankUser.setBankAccount(scanner.nextLine());

        System.out.print("Enter Mobile Number: ");
        bankUser.setMobileNumber(scanner.nextLine());
    }

    private void displayUserInformation(BankUser bankUser) {
        System.out.println("Bank user signed up successfully.");
        System.out.println("----------------------------------");
        System.out.println("Your Profile");
        System.out.println("Username: " + bankUser.getUsername());
        System.out.println("Password: " + bankUser.getPassword());
        System.out.println("Bank Name: " + bankUser.getBankName());
        System.out.println("Bank Account: " + bankUser.getBankAccount());
        System.out.println("Mobile Number: " + bankUser.getMobileNumber());
        System.out.println("----------------------------------");
    }


    public void displayAccountDetails(BankUser user) {
        System.out.println("Account Details:");
        System.out.println("Bank Name: " + user.getBankName());
        System.out.println("Bank Account: " + user.getBankAccount());
        System.out.println("Mobile Number: " + user.getMobileNumber());
        System.out.println("Balance: $" + user.getBalance());


    }
}
