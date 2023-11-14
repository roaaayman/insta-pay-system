package BillData;

import BillPaymentStrategy.*;


import java.util.ArrayList;
import java.util.List;

public class BankUserBills {
    public static List<IBill> initializeBills() {
        List<IBill> bills = new ArrayList<>();

        // Assuming you have instances of BankAccountPaymentStrategy, WalletAccountPaymentStrategy,
        // and InstaPayAccountPaymentStrategy already created
        IBIllPaymentStrategy gas = new GasBillPaymentStrategy();
        IBIllPaymentStrategy water = new WaterBillPaymentStrategy();
        IBIllPaymentStrategy electricity = new ElectricityBillPaymentStrategy();

        bills.add(new GasBill("123456789", 100.0, gas));
        bills.add(new GasBill("987654321", 75.0, gas));
        bills.add(new WaterBill("123456789", 50.0, water));
        bills.add(new ElectricityBill("555566667", 120.0, electricity));

        return bills;
}
}