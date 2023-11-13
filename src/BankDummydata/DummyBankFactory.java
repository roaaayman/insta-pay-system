package BankDummydata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyBankFactory {
    private static final Map<String, DummyUser> dummyUsers = new HashMap<>();

    static {
        dummyUsers.put("123456789", new DummyUser("dummyUser1", "password1"));
        dummyUsers.put("987654321", new DummyUser("dummyUser2", "password2"));
        dummyUsers.put("555566667", new DummyUser("dummyUser3", "password3"));
    }

    public static List<Bank> createBanks() {
        List<Bank> banks = new ArrayList<>();

        // Bank 1
        banks.add(new Bank("BankA", "123456789"));

        // Bank 2
        banks.add(new Bank("BankB", "987654321"));

        // Bank 3
        banks.add(new Bank("BankC", "555566667"));

        return banks;
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
