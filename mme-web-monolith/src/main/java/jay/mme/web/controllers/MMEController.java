package jay.mme.web.controllers;

import jay.mme.domain.User;
import jay.mme.web.formobjects.UserRegistrationRequest;
import jay.mme.web.formobjects.UserRegistrationResult;
import jay.mme.web.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


/**
 * Created by gkaiswarya on 21/06/15.
 */
@RestController
public class MMEController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MMEController.class);

    private UserService userService;

    @Autowired
    public MMEController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/login1", method = RequestMethod.POST)
    public HttpEntity<?> login1(String emailAddress, String password) {

        LOGGER.debug("Inside method MMEController.login1");

        User user = userService.login(emailAddress, password);

        if (user == null || user.getId() == null) return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);

        UriComponents uriComponents = UriComponentsBuilder.fromPath("/users/{id}").buildAndExpand(user.getId());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.SEE_OTHER);
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public User login(String emailAddress, String password) {
        return userService.login(emailAddress, password);
    }

    @RequestMapping("/users/{customerId}")
    public ResponseEntity<jay.mme.web.formobjects.User> profile(@PathVariable Long customerId) {

        LOGGER.debug("Inside method MMEController.profile");

        User domainUser = userService.getUserProfile(customerId);

        if (isNotFound(domainUser)) new ResponseEntity<jay.mme.web.formobjects.User>(HttpStatus.NOT_FOUND);

        jay.mme.web.formobjects.User copyDomainUser = new jay.mme.web.formobjects.User(domainUser.getId(), domainUser.getEmailAddress());
        List<Link> profileLinks = getLinksForProfile(copyDomainUser);
        copyDomainUser.add(profileLinks);

        return new ResponseEntity<jay.mme.web.formobjects.User>(copyDomainUser, HttpStatus.OK);
    }


    /**
     *
     * @param userRegistrationRequest
     * @return
     */
    @RequestMapping(value = "/users/registerUsers", method = RequestMethod.POST)
    public HttpEntity<UserRegistrationResult> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        User registeredUser = userService.registeredUser(new User(userRegistrationRequest.getEmailAddress(), userRegistrationRequest.getPassword()));

        if (!isUserRegistrationSucess(registeredUser)) {
            return new ResponseEntity<UserRegistrationResult>(new UserRegistrationResult(false, null), HttpStatus.BAD_REQUEST);
        }

        UserRegistrationResult userRegistrationResult =
                new UserRegistrationResult(true, new jay.mme.web.formobjects.User(registeredUser.getId(), registeredUser.getEmailAddress()));
        userRegistrationResult.add(getLiksForUserRegistration(userRegistrationResult));
        return new ResponseEntity<UserRegistrationResult>(userRegistrationResult, HttpStatus.OK);
    }

    @RequestMapping("/mme/test")
    public String test() {
        return "OK";
    }


    private List<Link> getLiksForUserRegistration(UserRegistrationResult userRegistrationResult) {
        List<Link> linksForUserRegistration = new ArrayList<Link>();
        try {
            Method profileMethod = MMEController.class.getMethod("profile", Long.class);
            Link selfLink = linkTo(MMEController.class, profileMethod, userRegistrationResult.getUser().getCustomerId()).withSelfRel();
            linksForUserRegistration.add(selfLink);
        } catch (NoSuchMethodException e) {
            LOGGER.debug("HATEOAS links could not be added to the response");
        }

        return linksForUserRegistration;
    }

    private List<Link> getLinksForProfile(jay.mme.web.formobjects.User copyDomainUser) {
        List<Link> linksForUserProfile = new ArrayList<Link>();
        try {
            Method projectsMethod = ProjectController.class.getMethod("getAllProjectsForCustomer", Long.class);
            Link projectsLink = linkTo(ProjectController.class, projectsMethod, copyDomainUser.getId()).withRel("projects");
            linksForUserProfile.add(projectsLink);
        } catch (NoSuchMethodException e) {
            LOGGER.debug("HATEOAS links could not be added to the response of MMEController.profile method");
        }

        return linksForUserProfile;
    }


    private boolean isUserRegistrationSucess(User registeredUser) {
        if (registeredUser == null || registeredUser.getId() == null) {
            return false;
        }
        return true;
    }

    private boolean isNotFound(User user) {
        return (user == null || user.getId() == null);
    }
}
