package Account;

public class InstapayAccountFactory implements AccountFactory{

    @Override
    public IAccount createAccount() {

        return new InstapayAccount();
    }
}
