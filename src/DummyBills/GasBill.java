package DummyBills;

public class GasBill extends Bill {
    public GasBill(String accountNumber, double amount) {
        super(accountNumber, amount);
    }

    @Override
    public String toString() {
        return "Gas Bill - Amount: " + getAmount() + " | Paid: " + isPaid();
    }
}