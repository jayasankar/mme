package jay.mme.web.controllers;

import jay.mme.domain.User;
import jay.mme.web.commands.user.UserLoginCommand;
import jay.mme.web.controllers.value.UserLoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gkaiswarya on 18/06/15.
 */
@RestController
public class UserController {

    static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserLoginCommand userLoginCommand;


    @Autowired
    public UserController(UserLoginCommand userLoginCommand) {
        this.userLoginCommand = userLoginCommand;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(UserLoginRequest userLoginRequest) {
        LOGGER.debug("Inside user controller.....");
        User user = userLoginCommand.login(userLoginRequest.getUserName(), userLoginRequest.getPassword());
        if (user == null || user.getId() == null) {
            return null;
        }
        return "redirect:/customers/"+user.getId()+"/projects";
    }
}
