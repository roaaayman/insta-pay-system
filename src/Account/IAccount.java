
package Account;

public interface IAccount {
    double getBalance();
    void setBalance(double b);
    double deductAmount(double amount);
    void deposit(double amount);



    String getAccountType();

    void displayAccountDetails();
}