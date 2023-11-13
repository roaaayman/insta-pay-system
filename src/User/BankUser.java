package User;

import Account.IAccount;
import Bill.IBill;
import Dummy.Bank;
import VerificationService.BankVerification;

import java.util.List;
import java.util.Scanner;

public class BankUser extends User {
    private String bankName;
    private String bankAccount;
    private String mobileNumber;


    public BankUser(String username, String password, String bankName, String bankAccount, String mobileNumber, IAccount Account) {
        super(username, password,Account);
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



    public double getBalance(){
        return getAccount().getBalance();
    }



    public void signUp(List<Bank> banks) {
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
            String bankName = scanner.nextLine();

            // Prompt the user for the bank account details as a string
            System.out.print("Enter Bank Account (as a string): ");
            String bankAccount = scanner.nextLine();

            // Prompt the user for the mobile number
            System.out.print("Enter Mobile Number: ");
            String mobileNumber = scanner.nextLine();

            // Check if the entered bank details exist in the list
            if (isBankValid(bankName, bankAccount, banks)) {
                setUsername(username);
                setPassword(password);

                System.out.println("Username: " + getUsername());
                System.out.println("Password: " + getPassword());
                System.out.println("Bank Name: " + bankName);
                System.out.println("Bank Account: " + bankAccount);
                System.out.println("Mobile Number: " + mobileNumber);

                BankVerification bankv = new BankVerification();
                boolean verified = bankv.verifyOTP(mobileNumber);
                if (verified) {
                    System.out.println("Bank user signed up successfully.");
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

    // Method to check if the entered bank details exist in the list
    private boolean isBankValid(String bankName, String bankAccount, List<Bank> banks) {
        for (Bank bank : banks) {
            if (bank.getBankName().equalsIgnoreCase(bankName) && bank.getBankAccount().equals(bankAccount)) {
                return true; // Bank details are valid
            }
        }
        return false; // Bank details are not found in the list
    }

    @Override
    public void payBill(IBill bill) {
        // Implement bill payment logic for bank user
        bill.payBill(this);
}
}