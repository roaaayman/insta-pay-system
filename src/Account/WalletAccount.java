package Account;

import Transferral.ITransferStrategy;
import Transferral.TransferToBank;
import Transferral.TransferToInstapayAccount;
import Transferral.TransferToWallet;

public class WalletAccount implements IAccount{
    private double balance;
    private String AccNum;



    public String getAccountNum()
    {
        return AccNum;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double b) {
        balance=b;
    }

    @Override
    public void transfer(IAccount destAcc, double amount,String destAccountNumber) {



        deductAmount(amount);
        if(destAcc instanceof  WalletAccount)
        {

        }
        else if(destAcc instanceof  InstapayAccount)
        {
            TransferToInstapayAccount transferToInstapayAccount=new TransferToInstapayAccount();
            transferToInstapayAccount.transfer(this,destAcc,amount,destAccountNumber);

        }
        else {
            System.out.println("Unsupported");
        }



    }
    public void deductAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Deduction successful. Remaining balance: " + balance);
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into " +
                "Wallet Account. New balance: $" + balance);
    }

    public String getAccountType() {
        return "Wallet Account";
    }
    public void displayAccountDetails() {
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Balance: $" + getBalance());

    }
}