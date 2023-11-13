package Dummy;

public class Bank {
    private String bankName;
    private String bankAccount;

    public Bank(String bankName, String bankAccount) {
        this.bankName = bankName;
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankAccount() {
        return bankAccount;
}
}