package User;

import BillPaymentStrategy.ElectricityBill;
import BillPaymentStrategy.GasBill;
import BillPaymentStrategy.IBill;
import BillPaymentStrategy.WaterBill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillPaymentService {

    public static void chooseAndPayBill(List<IBill> bills, double balance, String accnum, InstaPayUser instaPayUser) {
        Scanner scanner = new Scanner(System.in);

        // Display the bills associated with the user's account
        System.out.println("Bills associated with your account:");
        checkBills(bills,accnum);
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

                        List<IBill> updatedBills = new ArrayList<>(bills);
                        updatedBills.remove(selectedBill);
                        bills = updatedBills;
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



    public static void checkBills(List<IBill> bills, String accNum) {
        // Check bills associated with the user's account number
        for (IBill bill : bills) {
            if (bill.getAccountNumber().equals(accNum)) {
                if (bill.isPaid()) {
                    // Bill has already been paid
                    System.out.println("You have already paid a bill with amount $" + bill.getAmount());
                } else {
                    // Bill is unpaid
                    if (bill instanceof GasBill) {
                        System.out.println("You have an unpaid Gas bill with amount $" + bill.getAmount());
                    } else if (bill instanceof WaterBill) {
                        System.out.println("You have an unpaid Water bill with amount $" + bill.getAmount());
                    } else if (bill instanceof ElectricityBill) {
                        System.out.println("You have an unpaid Electricity bill with amount $" + bill.getAmount());
                    } else {
                        System.out.println("You have an unpaid bill with amount $" + bill.getAmount());
                    }
                }
            }
        }


    }}