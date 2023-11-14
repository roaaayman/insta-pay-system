package User;

import Account.IAccount;

public class WalletInstaPayUser extends InstaPayUser {
    private String mobileNumber;
    private String WalletProvider;
    public WalletInstaPayUser(String username, String password, String mobileNumber, String WalletProvider, IAccount Account) {
        super(username, password, Account);
        this.mobileNumber = mobileNumber;
    }
    public double getBalance() {
        return getAccount().getBalance();
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getWalletProvider() {
        return WalletProvider;
    }
    public void setWalletProvider(String walletprovider) {
        WalletProvider=walletprovider;
    }

    public void setMobileNumber(String mobnum) {
        mobileNumber=mobnum;
    }


}
