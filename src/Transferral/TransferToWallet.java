package Transferral;

import Account.BankAccount;
import Account.IAccount;
import Account.InstapayAccount;
import Account.WalletAccount;

public class TransferToWallet implements ITransferStrategy{
    @Override
    public void transfer(IAccount sourceAccount, IAccount destinationAccount, double amount,String destAccountNumber) {
        // Validate source account and destination account types
        if (!(sourceAccount instanceof WalletAccount || sourceAccount instanceof InstapayAccount || sourceAccount instanceof BankAccount) ||
                !(destinationAccount instanceof WalletAccount)) {
            throw new IllegalArgumentException("Invalid account types for this transfer strategy.");
        }

        // Check if the source account has sufficient balance
        if (sourceAccount.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds in the source account.");
        }
        sourceAccount.deductAmount(amount);
        destinationAccount.deposit(amount);

        // Implement logic for transferring to different account types
        // You may need to interact with the wallet provider's API or update the account balances
        System.out.println("Transferring " + amount + " to wallet account with number: "+destAccountNumber);

}
}