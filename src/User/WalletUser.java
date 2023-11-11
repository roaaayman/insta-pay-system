package User;

public class WalletUser extends User {
    private String mobileNumber;

    public WalletUser(String username, String password, String mobileNumber) {
        super(username, password);
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public void signUp() {
        if (getUsername() == null) {
            System.out.println("Signing up Wallet user...");
            System.out.println("Mobile Number: " + mobileNumber);
            System.out.println("Wallet user signed up successfully.");
        } else {
            System.out.println("Wallet user is already registered.");
        }
    }

    @Override
    public void displayAdditionalDetails() {
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Account Type: Wallet");
    }
}
