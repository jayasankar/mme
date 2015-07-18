package jay.mme.web.controllers.value;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gkaiswarya on 13/07/15.
 */
public class CreateProjectResponse {

    private final boolean projectCreationStatus;

    private final List<Project> projects;

    public CreateProjectResponse(boolean projectCreationStatus, List<jay.mme.domain.Project> domainProjectList) {
        this.projectCreationStatus = projectCreationStatus;
        projects = new ArrayList<Project>();
        BeanUtils.copyProperties(domainProjectList, projects);
    }

    public boolean isProjectCreationStatus() {
        return projectCreationStatus;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
