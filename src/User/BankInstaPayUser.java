package User;

import Account.IAccount;


import java.util.ArrayList;
import java.util.List;

public class BankInstaPayUser extends InstaPayUser {
    private String bankName;
    private String bankAccount;
    private String mobileNumber;



    public BankInstaPayUser(String username, String password, String bankName, String bankAccount, String mobileNumber, IAccount Account) {
        super(username, password, Account);
        this.bankName = bankName;
        this.bankAccount = bankAccount;
        this.mobileNumber = mobileNumber;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankname) {
        bankName=bankname;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobnum) {
        mobileNumber=mobnum;
    }


    public double getBalance() {
        return getAccount().getBalance();
    }
    public String getBankAccount()
    {
        return bankAccount;
    }
    public void setBankAccount(String bankaccount)
    {
        bankAccount=bankaccount;
    }






}