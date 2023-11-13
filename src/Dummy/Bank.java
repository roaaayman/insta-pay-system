package Dummy;

import User.BankUser;

import java.util.List;

public abstract class Bank {
    private String bankName;
    private String bankAccount;

    public Bank() {
        this.bankName = bankName;
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Bank Name: " + bankName + "\nBank Account: " + bankAccount;
    }

    public abstract List<BankUser> getBankUsers();

    public abstract void addBankUser(BankUser user);
}
