package jay.mme.web.controllers.value;

/**
 * Created by gkaiswarya on 11/07/15.
 */
public class User {

    private final Long customerId;

    private final String emailAddress;

    public User(Long customerId, String emailAddress) {
        this.customerId = customerId;
        this.emailAddress = emailAddress;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
