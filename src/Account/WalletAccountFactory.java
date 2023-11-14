package Account;

public class WalletAccountFactory implements IAccountFactory{
    @Override
    public IAccount createAccount() {
        // You can customize the account creation logic here
        return new WalletAccount();
    }
}
