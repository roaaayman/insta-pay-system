package User;


import Account.IAccount;
import Bill.IBill;

public interface IUser {
        void signUp(String username, String password, String mobilenumber, IAccount accountType);
        void signIn(String username, String password);
        void inquireBalance();
        double payBills(IBill billtype,double amount);
        UserProfile viewprofile();
    }


