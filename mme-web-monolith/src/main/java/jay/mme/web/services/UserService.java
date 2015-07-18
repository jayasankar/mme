package jay.mme.web.services;

import jay.mme.domain.User;
import jay.mme.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by gkaiswarya on 28/06/15.
 */
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserProfile(Long customerId) {
        return userRepository.findById(customerId);
    }

    /**
     *
     * @param emailAddress
     * @param password
     * @return
     */
    public User login(String emailAddress, String password) {
        return userRepository.findByEmailAddressAndPassword(emailAddress, password);
    }

    /**
     *
     * @param user
     * @return
     */
    public User registeredUser(User user) {
        return userRepository.save(user);
    }

}
