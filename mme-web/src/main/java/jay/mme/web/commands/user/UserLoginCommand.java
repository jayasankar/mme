package jay.mme.web.commands.user;

import jay.mme.domain.User;
import jay.mme.web.commands.user.events.LoginFailureEvent;
import jay.mme.web.commands.user.events.LoginStartEvent;
import jay.mme.web.commands.user.events.LoginSuccessEvent;
import jay.mme.web.events.Event;
import jay.mme.web.events.EventStore;
import jay.mme.web.repository.EventStoreRepository;
import jay.mme.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by gkaiswarya on 18/06/15.
 */
@Component
public class UserLoginCommand {


    @Autowired
    private EventStoreRepository eventStoreRepository;

    @Autowired
    private UserRepository userRepository;


    /**
     *
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName, String password) {

        User user = null;
        Event event;

        //FIXME : This is not ok
        //What happens if the "login start event" fails
        //What happens if the "login success / failure event" fails
        //Do we return logged in user or do we do something else?
        if (eventStoreRepository.save(new EventStore(this.getClass().getSimpleName(), new LoginStartEvent(userName))) != null) {
            user = userRepository.findByEmailAddressAndPassword(userName, password);
            if (user != null) {
                event = new LoginSuccessEvent(userName);
            } else {
                event = new LoginFailureEvent(userName);
            }
            eventStoreRepository.save(new EventStore(this.getClass().getSimpleName(), event));
        }

        return user;
    }
}
