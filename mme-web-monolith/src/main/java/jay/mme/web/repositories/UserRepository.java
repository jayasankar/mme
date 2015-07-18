package jay.mme.web.repositories;

import jay.mme.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by gkaiswarya on 28/06/15.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAddressAndPassword(String emailAddress, String password);

    User findById(Long id);

}
