package jay.mme.web.controller;

import jay.mme.App;
import jay.mme.domain.User;
import jay.mme.web.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


/**
 * Created by gkaiswarya on 04/07/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class MMEControllerTest {


    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        System.out.println("*****************Inside Test Login*************************");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        User test = new User("test@test.com", "test");
        User admin = new User("admin@admin.com", "admin");
        userRepository.deleteAll();
        userRepository.save(Arrays.asList(test, admin));
    }

    @Test
    public void testTest() throws Exception {
        this.mockMvc.perform(get("/mme/test")).andExpect(status().isOk());
    }

    @Test
    public void testLogin() throws Exception {

        System.out.println("*****************Inside Test Login*************************");

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = post("/users/login1");
        mockHttpServletRequestBuilder.param("emailAddress","test@test.com");
        mockHttpServletRequestBuilder.param("password","test");

        ResultActions resultActions = this.mockMvc.perform(mockHttpServletRequestBuilder);
        resultActions.andDo(print());
        resultActions.andExpect(status().is3xxRedirection());

    }

}
