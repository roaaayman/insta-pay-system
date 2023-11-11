package User;

import Account.BankAccount;

public class BankUser extends User {
    private String bankName;
    private BankAccount bankAccount;

    public BankUser(String username, String password, String bankName, String bankAccount) {
        super(username, password);
        this.bankName = bankName;
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    @Override
    public void signUp() {
        if (getUsername() == null) {
            System.out.println("Signing up Bank user...");
            System.out.println("Bank Name: " + bankName);
            System.out.println("Bank Account: " + bankAccount);
            System.out.println("Bank user signed up successfully.");
        } else {
            System.out.println("Bank user is already registered.");
        }
    }

    @Override
    public void displayAdditionalDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Type: Bank");
    }
}
