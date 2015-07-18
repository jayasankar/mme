package jay.mme.web.repository;

import jay.mme.domain.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by gkaiswarya on 13/07/15.
 */

public interface ProjectRepository extends CrudRepository<Project, Long> {

//    /**
//     * Returns list of projects for the same customer
//     * @param customerId
//     * @return
//     */
//    public List<Project> findByCustomerId(String customerId);

}
