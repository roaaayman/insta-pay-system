package VerificationService;

public interface IVerification {
    void sendOTP(String mobileNum);
    boolean verifyOTP(String OTP);
}
