package Account;

public class BankAccountFactory implements AccountFactory{

    @Override
    public IAccount createAccount() {

        return new BankAccount();
    }
}
