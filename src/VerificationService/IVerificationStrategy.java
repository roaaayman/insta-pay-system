package VerificationService;

public interface IVerificationStrategy {
    int sendOTP();
    boolean verifyOTP(String mobileNum);
}
