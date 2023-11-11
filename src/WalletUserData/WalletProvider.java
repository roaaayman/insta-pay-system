package WalletUserData;

import User.WalletUser;
import java.util.ArrayList;
import java.util.List;

public interface WalletProvider {

    String getProviderName();
    List<WalletUser> getWalletUsers();
    void addWalletUser(WalletUser user);
}
