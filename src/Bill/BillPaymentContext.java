package Bill;

public class BillPaymentContext {
    IBill bill;
    double amount;
    public BillPaymentContext(double amount, IBill bill) {
        this.amount = amount;
        this.bill = bill;
    }
    public void setBill(IBill bill) {
        this.bill = bill;
    }

}
