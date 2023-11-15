package BillPaymentStrategy;

import Bill.ElectricityBill;
import Bill.GasBill;
import Bill.IBill;
import Bill.WaterBill;
import User.InstaPayUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillPaymentService {

    public static void chooseAndPayBill(List<IBill> bills, double balance, String accnum, InstaPayUser instaPayUser) {
        Scanner scanner = new Scanner(System.in);


        // Display the bills associated with the user's account
        System.out.println("Bills associated with your account:");
        List<IBill> userBills =checkBills(bills, accnum);
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
                    if (balance >= selectedBill.getAmount()) {
                        // Pay the bill
                        selectedBill.payBill(instaPayUser);  // Pass the user as null, adjust the method if necessary
                        System.out.println("----------------------------------");
                       userBills.remove(selectedBill);
                    } else {
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



    public static List<IBill> checkBills(List<IBill> bills, String accNum) {
        List<IBill> userBills = new ArrayList<>();

        // Filter bills associated with the provided account number
        for (IBill bill : bills) {
            if (bill.getAccountNumber().equals(accNum)) {
                userBills.add(bill);
            }
        }

        // Check bills associated with the user's account number
        if (userBills.isEmpty()) {
            System.out.println("No bills associated with the provided account number.");
        } else {
            System.out.println("Bills associated with your account:");
            for (int i = 0; i < userBills.size(); i++) {
                IBill bill = userBills.get(i);
                String billDescription = "";

                // Customize the bill description based on the bill type
                if (bill instanceof GasBill) {
                    billDescription = "Gas bill with amount $" + bill.getAmount();
                } else if (bill instanceof WaterBill) {
                    billDescription = "Water bill with amount $" + bill.getAmount();
                } else if (bill instanceof ElectricityBill) {
                    billDescription = "Electricity bill with amount $" + bill.getAmount();
                } else {
                    billDescription = "Bill with amount $" + bill.getAmount();
                }

                System.out.println((i + 1) + ". " + billDescription);
            }
        }

        return userBills;
    }}
