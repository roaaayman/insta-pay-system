package BankDummydata;

import java.util.ArrayList;
import java.util.List;

public class DummyBankFactory {

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
}