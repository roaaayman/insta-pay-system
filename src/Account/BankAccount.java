package Account;

public class BankAccount implements IAccount{
    private double balance;
    @Override
    public double getBalance() {
        return balance;
    }
    @Override
    public void setBalance(double b) {
        balance=b;
    }

    @Override
    public double deductAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Deduction successful. Remaining balance: " + balance);

        }

        return 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into Bank Account");
    }


    public String getAccountType() {
        return "Bank Account";
    }
    public void displayAccountDetails() {
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Balance: $" + getBalance());

    }
}
