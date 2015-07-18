package jay.mme.web.formobjects;

/**
 * Created by gkaiswarya on 11/07/15.
 */
public class UserRegistrationRequest {

    private String emailAddress;

    private String password;

    private String confirmPassword;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
