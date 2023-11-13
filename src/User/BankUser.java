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



    @Override
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
            String userBankName = scanner.nextLine();

            // Prompt the user for the bank account details as a string
            System.out.print("Enter Bank Account (as a string): ");
            String userBankAccount = scanner.nextLine();

            // Check if the entered bank name and bank account match any banks in the list
            boolean bankFound = false;
            for (Bank bank : banks) {
                if (userBankName.equals(bank.getBankName()) && userBankAccount.equals(bank.getBankAccount())) {
                    bankFound = true;
                    break;
                }
            }

            if (bankFound) {
                setUsername(username);
                setPassword(password);

                System.out.println("Username: " + getUsername());
                System.out.println("Password: " + getPassword());
                System.out.println("Bank Name: " + userBankName);
                System.out.println("Bank Account: " + userBankAccount);

                BankVerification bankv = new BankVerification();
                boolean verified = bankv.verifyOTP(getMobileNumber());
                if (verified) {
                    System.out.println("Bank user signed up successfully.");
                } else {
                    System.out.println("OTP verification failed. Bank user not signed up.");
                }
            } else {
                System.out.println("Bank name and account not found in the list. Bank user not signed up.");
            }
        } else {
            System.out.println("Bank user is already registered.");
        }
    }


    @Override
    public void payBill(IBill bill) {
        // Implement bill payment logic for bank user
        bill.payBill(this);
    }
}
