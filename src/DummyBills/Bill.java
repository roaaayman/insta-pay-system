package DummyBills;

public class Bill {
    private String accountNumber;
    private double amount;
    private boolean paid;

    public Bill(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.paid = false; // Bills are initially unpaid
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void markAsPaid() {
        paid = true;
    }
}
