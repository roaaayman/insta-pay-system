package Account;

import Transferral.ITransferStrategy;
import Transferral.TransferToBank;
import Transferral.TransferToInstapayAccount;
import Transferral.TransferToWallet;

public class WalletAccount implements IAccount{
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

        IAccount srcAcc=new WalletAccount();

        deductAmount(amount);
        if(destAcc instanceof  WalletAccount)
        {
            TransferToWallet transferToWallet=new TransferToWallet();
            transferToWallet.transfer(srcAcc,destAcc,amount);

        }
        else if(destAcc instanceof  InstapayAccount)
        {
            TransferToInstapayAccount transferToInstapayAccount=new TransferToInstapayAccount();
            transferToInstapayAccount.transfer(srcAcc,destAcc,amount);

        }
        else {
            System.out.println("Unsupported");
        }



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
