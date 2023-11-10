package Account;

public class InstapayAccount implements IAccount{
    private double balance;
    private String username;
    private String password;
    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void createAccount() {

    }

    @Override
    public void transfer(IAccount destAcc, double amount) {

    }
}
