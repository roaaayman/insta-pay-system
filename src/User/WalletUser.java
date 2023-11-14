package User;

import Account.IAccount;
import BillPaymentStrategy.ElectricityBill;
import BillPaymentStrategy.GasBill;
import BillPaymentStrategy.IBill;
import BillPaymentStrategy.WaterBill;
import BillData.WalletUserBills;
import VerificationService.WalletVerification;
import WalletUserData.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WalletUser extends User {
    private String mobileNumber;
    private String WalletProvider;
    public WalletUser(String username, String password, String mobileNumber, String WalletProvider, IAccount Account) {
        super(username, password, Account);
        this.mobileNumber = mobileNumber;
    }
    public double getBalance() {
        return getAccount().getBalance();
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public String getWalletProvider() {
        return WalletProvider;
    }
    public void setWalletProvider(String walletprovider) {
        WalletProvider=walletprovider;
    }

    public void setMobileNumber(String mobnum) {
        mobileNumber=mobnum;
    }


}
