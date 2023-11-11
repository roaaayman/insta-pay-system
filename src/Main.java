import User.BankUser;
import User.WalletUser;

public class Main {
    public static void main(String[] args) {
        // Create and sign up a BankUser
        BankUser bankUser = new BankUser(null, null, null);
        bankUser.signUp();
        bankUser.displayAdditionalDetails();

        // Create and sign up a WalletUser
        WalletUser walletUser = new WalletUser(null, null, null);
        walletUser.signUp();
        walletUser.displayAdditionalDetails();
    }
}
