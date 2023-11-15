package Account;

import BankDummydata.Bank;
import BankDummydata.DummyBankFactory;
import Transferral.TransferToWallet;
import WalletUserData.Wallet;
import WalletUserData.WalletDummyFactory;

import java.util.List;

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