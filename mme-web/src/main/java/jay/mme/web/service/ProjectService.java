package jay.mme.web.service;

import jay.mme.domain.Project;
import jay.mme.web.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gkaiswarya on 13/07/15.
 */
@Component
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public List<Project> getProjectsForCustomer(String customerId) {
//        return projectRepository.findByCustomerId(customerId);
        return null;
    }

    public Project getProject(String customerId, Long projectId) {
        return projectRepository.findOne(projectId);
    }

}
