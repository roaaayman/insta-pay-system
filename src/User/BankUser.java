package User;

import Account.IAccount;
import BillPaymentStrategy.ElectricityBill;
import BillPaymentStrategy.GasBill;
import BillPaymentStrategy.IBill;
import BankDummydata.Bank;
import BillPaymentStrategy.WaterBill;
import VerificationService.BankVerification;
import BillData.BankUserBills;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankUser extends User {
    private String bankName;
    private String bankAccount;
    private String mobileNumber;
    private static List<BankUser> signedUpUsers = new ArrayList<>();

   // List<IBill> bills = BankUserBills.initializeBills();


    public BankUser(String username, String password, String bankName, String bankAccount, String mobileNumber, IAccount Account) {
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
