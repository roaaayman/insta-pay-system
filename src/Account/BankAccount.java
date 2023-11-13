package Account;

import BankDummydata.Bank;
import BankDummydata.DummyBankFactory;
import Transferral.TransferToBank;
import Transferral.TransferToWallet;
import WalletUserData.Wallet;
import WalletUserData.WalletDummyFactory;

import java.util.List;

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


    public void transfer(IAccount destAcc, double amount,String destAccountNumber) {
        List<Bank> banks = DummyBankFactory.createBanks();
        List<Wallet> wallets = WalletDummyFactory.createWallets();
        boolean isValidDestination = false;
        if (destAcc instanceof WalletAccount) {
            for (Wallet wallet : wallets) {
                if (wallet.getMobileNumber().equals(destAccountNumber)) {
                    isValidDestination = true;
                    TransferToWallet transferToWallet = new TransferToWallet();
                    transferToWallet.transfer(this, destAcc, amount, destAccountNumber);
                    break;
                }
            }
            if (!isValidDestination) {
                System.out.println("Invalid destination account number. Transfer failed.");
                return;
            }
        } else if (destAcc instanceof BankAccount) {
            for (Bank bank : banks) {
                if (bank.getBankAccount().equals(destAccountNumber)) {
                    isValidDestination = true;
                    TransferToBank transferToBank = new TransferToBank();
                    transferToBank.transfer(this, destAcc, amount, destAccountNumber);
                    break;
                }
            }
            if (!isValidDestination) {
                System.out.println("Invalid destination account number. Transfer failed.");
                return;
            }
        } else {
            System.out.println("Unsupported");


        }
    }

    public double deductAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Deduction successful. Remaining balance: " + balance);

        }

        return 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into Bank Account. New balance: $" + balance);
    }

    public String getAccountType() {
        return "Bank Account";
    }
    public void displayAccountDetails() {
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Balance: $" + getBalance());

    }
}
