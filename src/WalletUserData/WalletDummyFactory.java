
    package WalletUserData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class WalletDummyFactory {

        public static List<Wallet> createWallets() {
            List<Wallet> wallets = new ArrayList<>();

            // Wallet 1
            wallets.add(new Wallet("Vodafone cash", "01026224584"));

            // Wallet 2
            wallets.add(new Wallet("Orange cash", "01253050169"));

            // Wallet 3
            wallets.add(new Wallet("Etisalat cash", "01155690022"));

            return wallets;
        }


    }
