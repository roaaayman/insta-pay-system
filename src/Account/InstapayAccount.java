package Account;

import Transferral.ITransferStrategy;
import Transferral.TransferToBank;
import Transferral.TransferToInstapayAccount;
import Transferral.TransferToWallet;

public class InstapayAccount implements IAccount{
    private double balance;
    private String username;
    private String password;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double b) {
        balance=b;
    }



    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }


    @Override
    public void createAccount()
    {

    }

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

