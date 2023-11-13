package WalletUserData;
import User.WalletUser;
import java.util.ArrayList;
import java.util.List;

public class CustomerWalletProvider implements WalletProvider{
    private String providerName;
    private List<WalletAccount> walletUsers;

    public CustomerWalletProvider(String providerName) {
        this.providerName = providerName;
        this.walletUsers = new ArrayList<>();
    }

    @Override
    public String getProviderName() {
        return providerName;
    }

    @Override
    public List<WalletUser> getWalletUsers() {
        return new ArrayList<>(walletUsers); // Return a copy to prevent direct modification
    }

    @Override
    public void addWalletUser(WalletUser user) {
        walletUsers.add(user);
    }
}
