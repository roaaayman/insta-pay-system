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
    public void transfer(IAccount destAcc, double amount,String destAccountNumber) {


        deductAmount(amount);
        if(destAcc instanceof WalletAccount)
        {
            TransferToWallet transferToWallet=new TransferToWallet();
            transferToWallet.transfer(this,destAcc,amount,destAccountNumber);

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
    public double deductAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Deduction successful. Remaining balance: " + balance);
        }
        return amount;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into  Account. New balance: $" + balance);
    }
    public String getAccountType() {
        return "insta pay Account";
    }

   @Override
    public void displayAccountDetails() {
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Balance: $" + getBalance());

    }
}

