package jay.mme.domain;

/**
 * Created by gkaiswarya on 28/06/15.
 */
public class Collaborator {

    private final User user;

    public Collaborator(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
