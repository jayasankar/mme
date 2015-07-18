package jay.mme.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {

        ApplicationContext context = SpringApplication.run(App.class, args);
        LOGGER.debug("Application started.....");

    }
}
