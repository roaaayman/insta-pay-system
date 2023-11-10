package Account;

public interface IAccount {
    double getBalance();
    void setBalance(double b);
    void createAccount();
    void transfer(IAccount destAcc, double amount);
    void deductAmount(double amount);
}
