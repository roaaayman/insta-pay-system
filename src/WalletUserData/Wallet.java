package WalletUserData;

public class Wallet {
    private String WalletProvider;
    private String MobileNumber;

    public Wallet(String WalletProvider, String MobileNumber) {
        this.WalletProvider = WalletProvider;
        this.MobileNumber = MobileNumber;
    }

    public String getWalletProvider() {
        return WalletProvider;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }
}