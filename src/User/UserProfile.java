package User;

public class UserProfile {
    private String username;
    private String mobileNumber;

    public UserProfile(User user) {
        this.username = user.getUsername();
        this.mobileNumber = user.getMobileNumber();
    }

    public UserProfile(String username, String mobileNumber) {
    }

    public String getUsername() {
        return username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void displayAllDetails(User user) {
        System.out.println("User Details:");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Mobile Number: " + user.getMobileNumber());
        user.displayAdditionalDetails(); // This method should be implemented in WalletUser and BankUser
    }
}
