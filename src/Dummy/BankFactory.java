package Dummy;

import java.util.ArrayList;
import java.util.List;

public class BankFactory {
    public static List<Bank> createBanks() {
        List<Bank> banks = new ArrayList<>();

        // Bank 1
        Bank nbe = new Bank();
        banks.add(nbe);

        // Bank 2
        Bank bankMisr = new Bank();
        banks.add(bankMisr);

        // Bank 3
        Bank qnb = new Bank();
        banks.add(qnb);

        return banks;
    }
}
