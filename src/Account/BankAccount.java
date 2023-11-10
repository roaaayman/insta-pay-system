package Account;

import Transferral.ITransferStrategy;
import Transferral.TransferToBank;
import Transferral.TransferToInstapayAccount;
import Transferral.TransferToWallet;

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
    public void createAccount() {

    }

    @Override
    public void transfer(IAccount destAcc, double amount) {
        ITransferStrategy transferStrategy ;
        if(destAcc == new WalletAccount())
        {
            transferStrategy=new TransferToWallet();
        }
        else if(destAcc == new InstapayAccount())
        {
            transferStrategy=new TransferToInstapayAccount();
        }
        else if(destAcc==new BankAccount())
        {
            transferStrategy=new TransferToBank();
        }
        else {
            System.out.println("Unsupported");
        }
        deductAmount(amount);

    }
    public void deductAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Deduction successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds for the transfer.");
        }
    }
}
