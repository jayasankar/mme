package jay.mme.web.repositories;

import jay.mme.App;
import jay.mme.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by gkaiswarya on 04/07/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {
        User test = new User("test@test.com", "test");
        User admin = new User("admin@admin.com", "admin");
        userRepository.deleteAll();
        userRepository.save(Arrays.asList(test, admin));
    }

    @Test
    public void findByEmailAddressAndPassword() {
        User user = userRepository.findByEmailAddressAndPassword("admin@admin.com", "admin");
        assertEquals(user.getEmailAddress(), "admin@admin.com");
    }

}
