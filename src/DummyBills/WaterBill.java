package DummyBills;

public class WaterBill extends Bill {
    public WaterBill(String accountNumber, double amount) {
        super(accountNumber, amount);
    }

    @Override
    public String toString() {
        return "Water Bill - Amount: " + getAmount() + " | Paid: " + isPaid();
    }
}