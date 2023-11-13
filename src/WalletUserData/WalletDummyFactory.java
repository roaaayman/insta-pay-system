package WalletUserData;

import java.util.ArrayList;
import java.util.List;

public class WalletDummyFactory {

    public static List<Wallet> createWallets() {
        List<Wallet> Wallets = new ArrayList<>();

        // Bank 1
        Wallets.add(new Wallet("Vodafone cash", "01026224584"));

        // Bank 2
        Wallets.add(new Wallet("Orange cash", "01253050169"));

        // Bank 3
        Wallets.add(new Wallet("Etisalat cash", "01155690022"));

        return Wallets;
    }
}