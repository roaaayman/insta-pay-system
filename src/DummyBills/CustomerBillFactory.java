package DummyBills;

import Bill.ElectricityBill;
import Bill.GasBill;
import Bill.IBill;
import Bill.WaterBill;

import java.util.ArrayList;
import java.util.List;

public class CustomerBillFactory implements IDummyBill {

    @Override
    public List<IBill> createBills() {
        List<IBill> bills = new ArrayList<>();
        bills.add(new ElectricityBill(150.0));
        bills.add(new GasBill(75.0));
        bills.add(new WaterBill(50.0));
        return bills;
    }
}
