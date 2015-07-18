package jay.mme.web.controllers;

import jay.mme.web.commands.project.CreateProjectCommand;
import jay.mme.web.controllers.value.CreateProjectRequest;
import jay.mme.web.controllers.value.Project;
import jay.mme.web.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gkaiswarya on 14/06/15.
 */
@RestController
public class ProjectController {

    static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

    private ProjectService projectService;

    private CreateProjectCommand createProjectCommand;

    @Autowired
    public ProjectController(ProjectService projectService, CreateProjectCommand createProjectCommand) {
        this.projectService = projectService;
        this.createProjectCommand = createProjectCommand;
    }

    @RequestMapping(value = "customers/{customerId}/projects", method = RequestMethod.GET)
    public List<Project> getProjects(@PathVariable String  customerId) {

        LOGGER.debug("Inside ProjectController:getProjects");

        List<Project> copyDomainProjectList = new ArrayList<Project>();
        List<jay.mme.domain.Project> domainProjectList = projectService.getProjectsForCustomer(customerId);

        BeanUtils.copyProperties(domainProjectList, copyDomainProjectList);
        return copyDomainProjectList;
    }


    @RequestMapping(value = "customers/{customerId}/projects/{projectId}")
    public Project getProject(@PathVariable String customerId, @PathVariable Long projectId) {

        jay.mme.domain.Project domainProject = projectService.getProject(customerId, projectId);

        if (domainProject != null) {
            Project copyDomainProject = new Project(domainProject.getId(), domainProject.getName(), domainProject.getDescription(), null);
            return  copyDomainProject;
        }

        return null;
    }

    @RequestMapping(value = "customers/{customerId}/createProject")
    public String createProject(@PathVariable String customerId, @RequestBody CreateProjectRequest createProjectRequest) {

        LOGGER.debug("Inside ProjectController:createProject");

        jay.mme.domain.Project project = createProjectCommand.createProject(createDomainProject(createProjectRequest));
        if (project == null || project.getId() == null) {
            return null;
        }

        return "redirect:/customers/"+customerId+"/projects/"+project.getId();
    }

    private jay.mme.domain.Project createDomainProject(CreateProjectRequest createProjectRequest) {
        jay.mme.domain.Project domainProject = new jay.mme.domain.Project();
        domainProject.setName(createProjectRequest.getProjects().get(0).getName());
        domainProject.setDescription(createProjectRequest.getProjects().get(0).getDescription());
        return  domainProject;
    }






}
