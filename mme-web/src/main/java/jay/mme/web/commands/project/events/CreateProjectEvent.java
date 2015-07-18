package jay.mme.web.commands.project.events;

import jay.mme.domain.Project;
import jay.mme.web.events.Event;
import org.springframework.beans.BeanUtils;

/**
 * Created by gkaiswarya on 18/07/15.
 */
public class CreateProjectEvent implements Event {

    private final Project project;


    public CreateProjectEvent(Project domainProject) {
        this.project = new Project();
        BeanUtils.copyProperties(domainProject, project);
    }

    public Project getProject() {
        return project;
    }

}
