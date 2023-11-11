package WalletUserData;

public interface WalletProvider {

    String getProviderName();
    List<WalletUser> getWalletUsers();
    void addWalletUser(WalletUser user);
}
