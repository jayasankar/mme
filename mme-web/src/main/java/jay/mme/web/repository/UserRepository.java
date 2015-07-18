package jay.mme.web.repository;

import jay.mme.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gkaiswarya on 11/07/15.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByEmailAddressAndPassword(String emailAddress, String password);
}
