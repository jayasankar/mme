package jay.mme.web.controllers.value;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gkaiswarya on 18/06/15.
 */
public class Project {

    private final Long id;

    private final String name;

    private final String description;

    private final List<Project> projects;


    public Project(Long id, String name, String description, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.projects = new ArrayList<Project>(projects);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
