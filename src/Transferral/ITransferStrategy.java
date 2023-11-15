package Transferral;
import Account.IAccount;

public interface ITransferStrategy {
    void transfer(IAccount sourceAccount, IAccount destinationAccount, double amount,String destAccountNumber);

}