package jay.mme.web.formobjects;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by gkaiswarya on 11/07/15.
 */
public class UserRegistrationResult extends ResourceSupport {

    private final boolean registrationResult;

    private final User user;

    public UserRegistrationResult(boolean registrationResult, User user) {
        this.registrationResult = registrationResult;
        this.user = user;
    }

    public boolean isRegistrationResult() {
        return registrationResult;
    }

    public User getUser() {
        return user;
    }

}
