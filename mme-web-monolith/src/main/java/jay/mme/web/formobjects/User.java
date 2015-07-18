package jay.mme.web.formobjects;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by gkaiswarya on 11/07/15.
 */
public class User extends ResourceSupport {

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
