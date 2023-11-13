package DummyBills;

public class ElectricityBill extends Bill {
    public ElectricityBill(String accountNumber, double amount) {
        super(accountNumber, amount);
    }

    @Override
    public String toString() {
        return "Electricity Bill - Amount: " + getAmount() + " | Paid: " + isPaid();
    }
}