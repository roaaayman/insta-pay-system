package User;

import Account.BankAccount;
import Account.BankAccountFactory;
import User.BankUser;

public class BankUserFactory implements IUserFactory{
    @Override
    public User createUser(String username, String password) {
        return new BankUser(username, password, new BankAccountFactory());
    }

}
