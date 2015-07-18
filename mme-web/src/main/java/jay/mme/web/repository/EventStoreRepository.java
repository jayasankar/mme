package jay.mme.web.repository;

import jay.mme.web.events.EventStore;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gkaiswarya on 11/07/15.
 */
public interface EventStoreRepository extends CrudRepository<EventStore, Long> {


}
