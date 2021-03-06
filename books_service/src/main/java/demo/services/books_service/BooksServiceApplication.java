package demo.services.books_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BooksServiceApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BooksServiceApplication.class);

    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {
        logger.info("\n----Begin logging BooksServiceApplication----");

        logger.info("----System Properties from VM Arguments----");
        logger.info("server.port: " + System.getProperty("server.port"));
        logger.info("----Program Arguments----");
        for (String arg : args) {
            logger.info(arg);
        }

        if (environment != null) {
            getActiveProfiles();
            logger.info("----Environment Properties----");
            logger.info("server.port: " + environment.getProperty("server.port"));
            logger.info("environment: " + environment.getProperty("environment"));

        }

        logger.info("----End logging BooksServiceApplication----");
    }

    private void getActiveProfiles() {
        for (final String profileName : environment.getActiveProfiles()) {
            logger.info("Currently active profile - " + profileName);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(BooksServiceApplication.class, args);
    }

}
