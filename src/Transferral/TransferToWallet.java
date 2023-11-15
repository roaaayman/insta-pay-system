package Transferral;

import Account.BankAccount;
import Account.IAccount;
import Account.WalletAccount;
import WalletUserData.Wallet;
import WalletUserData.WalletDummyFactory;

import java.util.List;

public class TransferToWallet implements ITransferStrategy{
    @Override
    public void transfer(IAccount sourceAccount, IAccount destinationAccount, double amount,String destAccountNumber) {
        List<Wallet> wallets = WalletDummyFactory.createWallets();
        boolean isValidDestination = false;
        if (destinationAccount instanceof WalletAccount) {
            for (Wallet wallet : wallets) {
                if (wallet.getMobileNumber().equals(destAccountNumber)) {
                    isValidDestination = true;
                    destinationAccount.setBalance(0);
                    sourceAccount.deductAmount(amount);
                    destinationAccount.deposittodestAcc(amount);
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
}