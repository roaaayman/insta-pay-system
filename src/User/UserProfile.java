package User;
public class UserProfile {
    private String username;
    private String mobileNumber;

    public UserProfile(String username, String mobileNumber) {
        this.username = username;
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
