package BillData;

import BillPaymentStrategy.*;

import java.util.ArrayList;
import java.util.List;

public class WalletUserBills {

    public static List<IBill> initializeBills() {
        List<IBill> bills = new ArrayList<>();

        // Assuming you have instances of BankAccountPaymentStrategy, WalletAccountPaymentStrategy,
        // and InstaPayAccountPaymentStrategy already created
        IBIllPaymentStrategy gas = new GasBillPaymentStrategy();
        IBIllPaymentStrategy water = new WaterBillPaymentStrategy();
        IBIllPaymentStrategy electricity = new ElectricityBillPaymentStrategy();

        bills.add(new GasBill("01026224584", 30.0,gas)); // Adjusted amounts for wallet bills
        bills.add(new GasBill("01253050169", 45.0,gas));
        bills.add(new WaterBill("01155690022", 20.0,water));
        return bills;
    }
}
