package User;

import Account.BankAccountFactory;
import Account.WalletAccount;
import Account.WalletAccountFactory;

public class WalletUserFactory implements IUserFactory {
    @Override
    public User createUser(String username, String password) {
        return new WalletUser(username, password, new WalletAccountFactory());
    }

}
