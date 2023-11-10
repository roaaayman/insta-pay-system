package Account;

public interface IAccount {
    double getBalance();
    void createAccount();
    void transfer(IAccount destAcc,double amount);
}
