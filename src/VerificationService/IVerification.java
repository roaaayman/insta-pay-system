package VerificationService;

public interface IVerification {
    int sendOTP();
    boolean verifyOTP(String mobileNum);
}
