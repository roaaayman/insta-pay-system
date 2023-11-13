package Transferral;

import Account.BankAccount;
import Account.IAccount;
import Account.InstapayAccount;
import Account.WalletAccount;

public class TransferToBank implements ITransferStrategy{
    @Override
    public void transfer(IAccount sourceAccount, IAccount destinationAccount, double amount ) {
        // Validate source account and destination account types
        if (!(sourceAccount instanceof BankAccount) ||
                !(destinationAccount instanceof BankAccount || destinationAccount instanceof InstapayAccount || destinationAccount instanceof WalletAccount)) {
            throw new IllegalArgumentException("Invalid account types for this transfer strategy.");
        }

        // Check if the source account has sufficient balance
        if (sourceAccount.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds in the source account.");
        }

        // Implement logic for transferring to different account types
        // You may need to interact with the bank API or update the account balances
        System.out.println("Transferring " + amount + " from Bank account to another account type.");
}
}