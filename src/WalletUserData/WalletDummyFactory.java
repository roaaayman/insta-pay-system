package WalletUserData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletDummyFactory {
    private static final Map<String, DummyUser> dummyUsers = new HashMap<>();

    static {
        dummyUsers.put("01026224584", new DummyUser("walletUser1", "password1"));
        dummyUsers.put("01253050169", new DummyUser("walletUser2", "password2"));
        dummyUsers.put("01155690022", new DummyUser("walletUser3", "password3"));
    }

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

    public static DummyUser getDummyUser(String accountNumber) {
        return dummyUsers.get(accountNumber);
    }

    public static class DummyUser {
        private final String username;
        private final String password;

        public DummyUser(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
