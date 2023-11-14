package Account;

public class BankAccountFactory implements IAccountFactory{
    @Override
    public IAccount createAccount() {
        // You can customize the account creation logic here
        return new BankAccount(0.0);
    }
}
