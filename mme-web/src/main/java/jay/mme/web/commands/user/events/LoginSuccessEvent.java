package jay.mme.web.commands.user.events;

import jay.mme.web.events.Event;
import jay.mme.web.events.EventStore;

/**
 * Created by gkaiswarya on 06/07/15.
 */
public class LoginSuccessEvent implements Event {

    private String userName;

    public LoginSuccessEvent(String userName) {
        this.userName = userName;
    }
}
