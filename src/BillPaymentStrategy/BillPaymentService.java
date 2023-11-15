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

    public static List<IBill> chooseAndPayBill(List<IBill> bills, double balance, String accnum, InstaPayUser instaPayUser) {
        Scanner scanner = new Scanner(System.in);
        List<IBill> userBills = checkBills(bills, accnum);

        // Display the unpaid bills associated with the user's account

        System.out.print("Enter the number of the bill you want to pay (1, 2, 3, ...): ");
        int billNumber = scanner.nextInt();

        if (billNumber >= 1 && billNumber <= userBills.size()) {
            IBill selectedBill = userBills.get(billNumber - 1);

            if (!selectedBill.isPaid()) {
                System.out.print("Do you want to pay this bill? (yes/no): ");
                String confirmation = scanner.next().toLowerCase();

                if (confirmation.equals("yes")) {
                    if (balance >= selectedBill.getAmount()) {
                        selectedBill.payBill(instaPayUser);
                        userBills.remove(selectedBill);
                        System.out.println("----------------------------------");
                        if (userBills.isEmpty()) {
                            System.out.println("No bills associated with your account.");
                        } else {
                            System.out.println("Updated Bills associated with your account:");
                            for (int i = 0; i < userBills.size(); i++) {
                                IBill bill = userBills.get(i);
                                String billType = ""; // Replace these with actual properties from your IBill interface
                                double amount ;
                                boolean isPaid ;

                                // Retrieve bill information
                                if (bill instanceof GasBill) {
                                    billType = "Gas bill";
                                } else if (bill instanceof WaterBill) {
                                    billType = "Water bill";
                                } else if (bill instanceof ElectricityBill) {
                                    billType = "Electricity bill";
                                }

                                amount = bill.getAmount();
                                isPaid = bill.isPaid();
                                // Display bill details
                                System.out.println((i + 1) + ". " + billType + " with amount $" + amount + ", Paid: " + isPaid);
                            }
                        }



                        // Remove the paid bill from the userBills list by index
                        userBills.remove(selectedBill);

                        return userBills; // Return the updated list after removing the paid bill
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

        return userBills; // Return the original list if no changes were made or payment canceled
    }


    public static List<IBill> checkBills(List<IBill> bills, String accNum) {
        List<IBill> userBills = new ArrayList<>();

        // Filter unpaid bills associated with the provided account number
        for (IBill bill : bills) {
            if (bill.getAccountNumber().equals(accNum) && !bill.isPaid()) {
                userBills.add(bill);
            }
        }

        // Check unpaid bills associated with the user's account number
        if (userBills.isEmpty()) {
            System.out.println("No unpaid bills associated with the provided account number.");
        } else {
            System.out.println("Unpaid bills associated with your account:");
            for (int i = 0; i < userBills.size(); i++) {
                IBill bill = userBills.get(i);
                String billType = getBillType(bill);
                double amount = bill.getAmount();

                // Display bill details
                System.out.println((i + 1) + ". " + billType + " with amount $" + amount);
            }
        }

        return userBills;
    }

    // Helper method to get bill type
    private static String getBillType(IBill bill) {
        if (bill instanceof GasBill) {
            return "Gas bill";
        } else if (bill instanceof WaterBill) {
            return "Water bill";
        } else if (bill instanceof ElectricityBill) {
            return "Electricity bill";
        }
        return "Unknown bill type";
    }}



