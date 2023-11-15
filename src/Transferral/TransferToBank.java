package Transferral;

import Account.BankAccount;
import Account.IAccount;
import BankDummydata.Bank;
import BankDummydata.DummyBankFactory;
import WalletUserData.Wallet;
import WalletUserData.WalletDummyFactory;

import java.util.List;

public class TransferToBank implements ITransferStrategy{
    @Override
    public void transfer(IAccount sourceAccount, IAccount destinationAccount, double amount, String destAccountNumber) {
        List<Bank> banks = DummyBankFactory.createBanks();
        boolean isValidDestination = false;

         if (destinationAccount instanceof BankAccount) {
            for (Bank bank : banks) {
                if (bank.getBankAccount().equals(destAccountNumber)) {
                    isValidDestination = true;
                    sourceAccount.deductAmount(amount);
                    sourceAccount.setBalance(sourceAccount.getBalance()-amount);
                    destinationAccount.deposit(amount);
                    destinationAccount.setBalance(amount);
                    break;
                }
            }
        } else {
            System.out.println("Unsupported account type");
        }

        if (!isValidDestination) {
            System.out.println("Invalid destination account number. Transfer failed.");
        }
    }

}
