package jay.mme.domain;

/**
 * Created by gkaiswarya on 28/06/15.
 */
public class Owner {

    private final User user;

    public Owner(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
