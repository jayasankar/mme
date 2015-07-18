package jay.mme.web.commands.user.events;

import jay.mme.web.events.Event;
import jay.mme.web.events.EventStore;

/**
 * Created by gkaiswarya on 18/06/15.
 */
public class LoginStartEvent implements Event {

    private Long id;

    private final String userName;

    public LoginStartEvent(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
