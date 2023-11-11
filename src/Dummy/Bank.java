package Dummy;

import User.BankUser;

import java.util.List;

public interface Bank {
    String getBankName();

    List<BankUser> getBankUsers();

    void addBankUser(User.BankUser bankuser);
}
