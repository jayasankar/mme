package jay.mme.web.controllers;

import jay.mme.domain.Project;
import jay.mme.domain.Task;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gkaiswarya on 21/06/15.
 */
@RestController
public class ProjectController {

    @RequestMapping(value = "/customers/{customerId}/projects")
    public Project getAllProjectsForCustomer(@PathVariable String customerId){
        return null;
    }

    @RequestMapping(value = "/customers/{customerId}/projects/{projectId}")
    public List<Project> getProjectForCustomer(@PathVariable String customerId, @PathVariable String projectId) {
        return null;
    }

}
