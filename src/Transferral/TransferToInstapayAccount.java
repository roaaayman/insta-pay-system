package Transferral;

import Account.BankAccount;
import Account.IAccount;
import Account.InstapayAccount;
import Account.WalletAccount;

public class TransferToInstapayAccount implements ITransferStrategy {
    @Override
    public void transfer(IAccount sourceAccount, IAccount destinationAccount, double amount,String destAccountNumber) {
        // Validate destination account type
        if (!(destinationAccount instanceof InstapayAccount || destinationAccount instanceof WalletAccount)) {
            throw new IllegalArgumentException("Invalid account type for this transfer strategy.");
        }

        // Check if the source account has sufficient balance
        if (sourceAccount.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds in the source account.");
        }

        // Implement logic for transferring to another Instapay account
        // You may need to update the account balances
        System.out.println("Transferring " + amount + " to Instapay account.");


    }
}
