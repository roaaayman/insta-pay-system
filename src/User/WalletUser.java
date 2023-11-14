package User;

import Account.IAccount;
import Account.IAccountFactory;
import BillPaymentStrategy.ElectricityBill;
import BillPaymentStrategy.GasBill;
import BillPaymentStrategy.IBill;
import BillPaymentStrategy.WaterBill;
import BillData.WalletUserBills;
import VerificationService.WalletVerification;
import WalletUserData.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WalletUser extends User {
    private String mobileNumber;
    private String WalletProvider;
    List<IBill> bills = WalletUserBills.initializeBills();


    public WalletUser(String username, String password, IAccountFactory accountFactory) {
        super(username, password, accountFactory.createAccount());
        this.mobileNumber = getMobileNumber();
        this.WalletProvider=getWalletProvider();
    }


    public double getBalance() {
        return getAccount().getBalance();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getWalletProvider() {
        return WalletProvider;
    }
    public void setWalletProvider(String walletprovider) {
        WalletProvider=walletprovider;
    }


    public void setMobileNumber(String mobnum) {
        mobileNumber=mobnum;
    }

    public void signUp(List<Wallet> Wallets) {
        if (getUsername() == null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Signing up Wallet user...");

            // Prompt the user for username
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            // Prompt the user for password
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            // Prompt the user for the mobile number
            System.out.print("Enter Mobile Number: ");
            mobileNumber = scanner.nextLine();

            System.out.print("Enter Wallet Provider: ");
            WalletProvider = scanner.nextLine();
            setUsername(username);
            setPassword(password);
            setWalletProvider(WalletProvider);
            setMobileNumber(mobileNumber);

            WalletVerification walletv = new WalletVerification();
            if (walletv.isWalletValid(WalletProvider, mobileNumber, Wallets)) {
                setUsername(username);
                setPassword(password);

                System.out.println("Account Available in Wallet provider "+WalletProvider);
                System.out.println("----------------------------------");
                loadDetails();


                boolean verified = walletv.verifyOTP(mobileNumber);
                if (verified) {

                } else {
                    System.out.println("OTP verification failed. Wallet user not signed up.");
                }
            } else {
                System.out.println("Invalid Wallet details. Wallet user not signed up.");
            }

        } else {
            System.out.println("Wallet user is already registered.");
        }
    }

    public void loadDetails()
    {
        System.out.println("Wallet user signed up successfully.");
        System.out.println("----------------------------------");
        System.out.println("Your Profile");
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword());
        System.out.println("Wallet Provider Name: " + WalletProvider);
        System.out.println("Mobile Number associated with the wallet: " + mobileNumber);
    }

    public void checkBills(List<IBill> bills) {
        for (IBill bill : bills) {
            if (bill.getAccountNumber().equals(mobileNumber)) {
                if (bill instanceof GasBill) {
                    System.out.println("You have a Gas bill with amount $" + bill.getAmount());
                } else if (bill instanceof WaterBill) {
                    System.out.println("You have a Water bill with amount $" + bill.getAmount());
                } else if (bill instanceof ElectricityBill) {
                    System.out.println("You have an Electricity bill with amount $" + bill.getAmount());
                } else {
                    System.out.println("You have a bill with amount $" + bill.getAmount());
                }
            }
        }
    }
    public void chooseAndPayBill() {
        Scanner scanner = new Scanner(System.in);

        // Display the bills associated with the user's account
        System.out.println("Bills associated with your account:");
        checkBills(bills);
        System.out.println("----------------------------------");


        // Prompt the user to choose a bill
        System.out.print("Enter the number of the bill you want to pay (1, 2, 3, ...): ");
        int billNumber = scanner.nextInt();
        System.out.println("----------------------------------");

        // Ensure the entered bill number is valid
        if (billNumber >= 1 && billNumber <= bills.size()) {
            IBill selectedBill = bills.get(billNumber - 1);

            // Check if the bill is already paid
            if (!selectedBill.isPaid()) {
                // Display the details of the selected bill


                // Prompt the user to confirm the payment
                System.out.print("Do you want to pay this bill? (yes/no): ");
                String confirmation = scanner.next().toLowerCase();

                if (confirmation.equals("yes")) {
                    if (getBalance() >= selectedBill.getAmount()) {
                        // Pay the bill
                        payBill(selectedBill);
                        System.out.println("----------------------------------");

                        List<IBill> updatedBills = new ArrayList<>(bills);
                        updatedBills.remove(selectedBill);
                        bills = updatedBills;
                    }
                    else {
                        System.out.println("Insufficient balance to pay the bill.");
                        System.out.println("----------------------------------");

                    }
                } else {
                    System.out.println("Payment canceled.");
                    System.out.println("----------------------------------");
                }
            } else {
                System.out.println("This bill has already been paid.");
                System.out.println("----------------------------------");
            }
        } else {
            System.out.println("Invalid bill number. Please enter a valid number.");
            System.out.println("----------------------------------");
        }
    }


    @Override
    public void payBill(IBill bill) {
        // Implement bill payment logic for wallet user
        bill.payBill(this);
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Mobile Number: " + getMobileNumber());
        System.out.println("Wallet Provider: " + getWalletProvider());
        System.out.println("Balance: $" + getBalance());
        if (bills != null) {
            checkBills(bills);
        } else {
            System.out.println("No bills available.");
        }
    }
}
