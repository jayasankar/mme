package jay.mme.web.controllers.value;

/**
 * Created by gkaiswarya on 11/07/15.
 */
public class UserLoginResponse {

    private final boolean loginStatus;

    private final User user;

    public UserLoginResponse(boolean loginStatus, User user) {
        this.loginStatus = loginStatus;
        this.user = user;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public User getUser() {
        return user;
    }
}
