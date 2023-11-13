package DummyBills;

import Bill.ElectricityBill;
import Bill.IBill;
import java.util.ArrayList;
import java.util.List;

public class ElectricityBillFactory implements IDummyBill {

    @Override
    public List<IBill> createBills() {
        List<IBill> electricityBills = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            electricityBills.add(new ElectricityBill(100.0 * i));
        }
        return electricityBills;
    }
}


