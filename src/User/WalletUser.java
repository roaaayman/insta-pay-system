package User;

import Account.IAccount;
import Bill.IBill;

public class WalletUser implements IUser {
    @Override
    public void signUp(String username, String password, String mobilenumber, IAccount accountType) {

    }

    @Override
    public void signIn(String username, String password) {

    }

    @Override
    public void inquireBalance() {

    }

    @Override
    public double payBills(IBill billtype, double amount) {
        return 0;
    }

    @Override
    public UserProfile viewprofile() {
        return null;
    }
}
