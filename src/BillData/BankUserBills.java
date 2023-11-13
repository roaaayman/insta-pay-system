package BillData;

import java.util.ArrayList;
import java.util.List;
import Bill.IBill;
import Bill.GasBill;
import Bill.WaterBill;
import Bill.ElectricityBill;

public class BankUserBills {
    public static List<IBill> initializeBills() {
        List<IBill> bills = new ArrayList<>();
        bills.add(new GasBill("123456789", 100.0));
        bills.add(new GasBill("987654321", 75.0));
        bills.add(new WaterBill("123456789", 50.0));
        bills.add(new ElectricityBill("555566667", 120.0));
        return bills;
    }
}
