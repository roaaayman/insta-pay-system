package Dummy;

import java.util.ArrayList;
import java.util.List;

public class ConcreteBank implements Bank {
    private String bankName;
    private List<User.BankUser> bankUsers;

    public ConcreteBank(String bankName) {
        this.bankName = bankName;
        this.bankUsers = new ArrayList<>();
    }

    @Override
    public String getBankName() {
        return bankName;
    }

    @Override
    public List<User.BankUser> getBankUsers() {
        return new ArrayList<>(bankUsers); // Return a copy to prevent direct modification
    }

    @Override
    public void addBankUser(User.BankUser user) {
        bankUsers.add(user);
    }
}