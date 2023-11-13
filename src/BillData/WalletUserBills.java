package BillData;

import Bill.ElectricityBill;
import Bill.GasBill;
import Bill.IBill;
import Bill.WaterBill;

import java.util.ArrayList;
import java.util.List;

public class WalletUserBills {
    public static List<IBill> initializeBills() {
        List<IBill> bills = new ArrayList<>();
        bills.add(new GasBill("01026224584", 30.0)); // Adjusted amounts for wallet bills
        bills.add(new GasBill("01253050169", 45.0));
        bills.add(new WaterBill("01155690022", 20.0));
        return bills;
    }
}
