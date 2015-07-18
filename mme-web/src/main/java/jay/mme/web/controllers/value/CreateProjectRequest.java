package jay.mme.web.controllers.value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gkaiswarya on 13/07/15.
 */
public class CreateProjectRequest {

    private List<Project> projects = new ArrayList<Project>();

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
