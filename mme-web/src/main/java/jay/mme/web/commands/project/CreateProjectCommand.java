package jay.mme.web.commands.project;

import jay.mme.domain.Project;
import jay.mme.web.commands.project.events.CreateProjectEvent;
import jay.mme.web.events.EventStore;
import jay.mme.web.repository.EventStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by gkaiswarya on 17/07/15.
 */
@Component
public class CreateProjectCommand {

    @Autowired
    private EventStoreRepository eventStoreRepository;

    public Project createProject(Project projectToCreate) {
        //FIXME : How do we return the saved project?
        //Project has an id and this should be same irrespective of the store
        //The idea could be to use a different view to return project
        eventStoreRepository.save(new EventStore(this.getClass().getSimpleName(), new CreateProjectEvent(projectToCreate)));
        return null;
    }
}
