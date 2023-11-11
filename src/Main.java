import Account.*;
import User.user;
import VerificationService.BankVerification;
import VerificationService.IVerification;
import VerificationService.WalletVerification;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AccountFactory bank=new BankAccountFactory();
        AccountFactory wallet=new WalletAccountFactory();
        IVerification bankv=new BankVerification();
        IVerification walletv=new WalletVerification();
        user user = new user();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Instapay!");

        System.out.print("Do you want to sign up or sign in? (signup/signin): ");
        String choice = scanner.nextLine();
        String username,password,mobileNum;

        if(choice.equals("signup")) {
            System.out.println("Enter your username");
            username= scanner.nextLine();
            System.out.println("Enter your password");
            password= scanner.nextLine();
            System.out.println("Enter your mobile number");
            mobileNum= scanner.nextLine();


            System.out.print("Select account type (bank/wallet): ");
            String accountType = scanner.nextLine();

            if(accountType.equals("bank")) {
                IAccount bankAccount=bank.createAccount();
                user.signUp(username,password,mobileNum,bankAccount);
                System.out.println("sending OTP...");
                System.out.println(bankv.sendOTP());
                bankv.verifyOTP(mobileNum);
            }
            else if(accountType.equals("wallet"))
            {
                IAccount walletaccount=wallet.createAccount();
                user.signUp(username,password,mobileNum,walletaccount);
            }



        } else if(choice.equals("signin")) {

            System.out.print("Enter username: ");
             username = scanner.nextLine();
            System.out.println("Enter your password");
            password= scanner.nextLine();
            user.signIn(username,password);
        }

        System.out.print("What would you like to do? (transfer/paybill): ");
        String action = scanner.nextLine();

        if(action.equals("transfer")) {

            // prompt for transfer details
            // perform transfer

        } else if(action.equals("paybill")) {

            // prompt for bill details
            // perform bill payment

        }

    }

}