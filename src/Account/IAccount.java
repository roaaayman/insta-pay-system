package Account;

public interface IAccount {
    double getBalance();
    void setBalance(double b);
    void transfer(IAccount destAcc, double amount,String destAccountNumber);
    double deductAmount(double amount);
    void deposit(double amount);



    String getAccountType();

    void displayAccountDetails();
}
