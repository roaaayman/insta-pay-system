package User;

import BankDummydata.Bank;
import BillData.BankUserBills;
import BillPaymentStrategy.BillPaymentService;
import Bill.IBill;
import VerificationService.BankVerificationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankUserController {
    BankInstaPayUser bankuser;
    List<IBill> bills = BankUserBills.initializeBills();

    private static List<BankInstaPayUser> signedUpUsers = new ArrayList<>();

    public void setBankinfo(BankInstaPayUser bankacc, String username, String password, String bankName, String bankAccount,String mobilenumber)
    {
        bankuser=bankacc;
        bankuser.setPassword(password);
        bankuser.setUsername(username);
        bankuser.setMobileNumber(mobilenumber);
        bankuser.setBankAccount(bankAccount);
        bankuser.setBankName(bankName);
    }
    public void signUpBankUser(List<Bank> banks, BankInstaPayUser bankUser) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Signing up Bank user...");

        if (bankUser.getUsername() == null) {
            promptUserForDetails(bankUser);

            BankVerificationStrategy bankv = new BankVerificationStrategy();

            if (bankv.isBankValid(bankUser.getBankName(), bankUser.getBankAccount(), banks)) {

                System.out.println("Account Available in bank " + bankUser.getBankName());
                System.out.println("----------------------------------");
                loadDetails();


                System.out.println("----------------------------------");

                boolean verified = bankv.verifyOTP(bankUser.getMobileNumber());
                if (verified) {
                    loadDetails();
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
    public BankInstaPayUser signInBankUser(List<BankInstaPayUser> bankUsers) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();

        for (BankInstaPayUser user : bankUsers) {
            if (user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
                return user; // Return the authenticated user
            }
        }

        return null; // Return null if authentication fails
    }
    private void promptUserForDetails( BankInstaPayUser bankuser) {
        Scanner scanner = new Scanner(System.in);


        // Prompt the user for username
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        // Prompt the user for password
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter bank name: ");
        String bankname = scanner.nextLine();
        System.out.print("Enter bank account number: ");
        String bankacc = scanner.nextLine();

        // Prompt the user for the mobile number
        System.out.print("Enter Mobile Number: ");
        String mobileNumber = scanner.nextLine();


        setBankinfo(bankuser,username,password,bankname,bankacc,mobileNumber);

    }
    public void loadDetails()
    {
        System.out.println("Bank user signed up successfully.");
        System.out.println("----------------------------------");
        System.out.println("Your Profile");
        System.out.println("Username: " + bankuser.getUsername());
        System.out.println("Password: " + bankuser.getPassword());
        System.out.println("bank Name: " + bankuser.getBankName());
        System.out.println("account Number associated with the bank: " + bankuser.getBankAccount());
        System.out.println("mobile number: " + bankuser.getMobileNumber());
    }





    public void displayAccountDetails(BankInstaPayUser user) {

        System.out.println("Account Details:");
        System.out.println("Bank Name: " + user.getBankName());
        System.out.println("Bank Account: " + user.getBankAccount());
        System.out.println("Mobile Number: " + user.getMobileNumber());
        System.out.println("Balance: $" + user.getBalance());
        if (bills != null) {
            BillPaymentService.checkBills(bills,user.getBankAccount());
        } else {
            System.out.println("No bills available.");
        }
        // Additional logic for displaying bills if needed
    }
}