package jay.mme.web.commands.user.events;

import jay.mme.web.events.Event;
import jay.mme.web.events.EventStore;

/**
 * Created by gkaiswarya on 06/07/15.
 */
public class LoginFailureEvent implements Event {

    private String userName;

    public LoginFailureEvent(String userName) {
        this.userName = userName;
    }

}
