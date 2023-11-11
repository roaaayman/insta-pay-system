package WalletUserData;

import User.WalletUser;


import java.util.ArrayList;
import java.util.List;

public class WalletProviderFactory {

    public static List<WalletProvider> createWalletProviders() {
        List<WalletProvider> walletProviders = new ArrayList<>();

        // Wallet Provider 1
        CustomerWalletProvider provider1 = new CustomerWalletProvider("Vodafone Cash");
        provider1.addWalletUser(new User.WalletUser("User1", "1234123412","0114433332"));
        provider1.addWalletUser(new User.WalletUser("User2", "5678567856","0114433333"));
        walletProviders.add(provider1);

        // Wallet Provider 2
        CustomerWalletProvider provider2 = new CustomerWalletProvider("Orange Cash");
        provider2.addWalletUser(new User.WalletUser("User3", "9876987698","011443334"));
        provider2.addWalletUser(new User.WalletUser("User4", "1111222233","0114433332"));
        walletProviders.add(provider2);

        // Wallet Provider 3
        CustomerWalletProvider provider3 = new CustomerWalletProvider("Etisalat Cash");
        provider3.addWalletUser(new User.WalletUser("User5", "4444555566","0114433332"));
        provider3.addWalletUser(new User.WalletUser("User6", "7777888899","0114433332"));
        walletProviders.add(provider3);

        return walletProviders;
    }
}
