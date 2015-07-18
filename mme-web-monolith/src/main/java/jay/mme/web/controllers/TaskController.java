package jay.mme.web.controllers;

import jay.mme.domain.Task;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gkaiswarya on 28/06/15.
 */
@RestController
public class TaskController {

    @RequestMapping(value = "/projects/{id}/addTask", method = RequestMethod.POST)
    public Task addTask(@PathVariable String id, Task task) {
        return null;
    }

}
