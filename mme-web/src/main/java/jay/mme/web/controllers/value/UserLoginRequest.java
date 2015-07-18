package jay.mme.web.controllers.value;

/**
 * Created by gkaiswarya on 18/06/15.
 */
public class UserLoginRequest {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
