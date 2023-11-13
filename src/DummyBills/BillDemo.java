package DummyBills;

import java.util.ArrayList;
import java.util.List;

public class BillDemo {
    public static void main(String[] args) {
        List<Bill> bills = new ArrayList<>();
        bills.add(new GasBill("123456789", 100.0));
        bills.add(new GasBill("987654321", 75.0));
        bills.add(new WaterBill("123456789", 50.0));
        bills.add(new ElectricityBill("555566667", 120.0));

        // You can now work with the bills in this class or package.
    }
}
