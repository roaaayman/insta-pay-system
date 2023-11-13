package User;

import Account.IAccount;
import Bill.IBill;
import Dummy.Bank;
import VerificationService.BankVerification;
import VerificationService.IVerification;
import VerificationService.WalletVerification;

import java.util.List;
import java.util.Scanner;

public class WalletUser extends User {
    private String mobileNumber;


    public WalletUser(String username, String password, String mobileNumber, IAccount Account) {
        super(username, password,Account);
        this.mobileNumber = mobileNumber;
    }

    public double getBalance(){
        return getAccount().getBalance();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }


    @Override
    public void signUp(List<Bank> banks) {

    }

    @Override
    public void payBill(IBill bill) {
        // Implement bill payment logic for wallet user
        bill.payBill(this);
    }


}