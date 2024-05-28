package cz.czechitas.java2webapps.lekce8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hlavní třída, která spouští celou aplikaci pomocí Spring Boot.
 * <p>
 * Anotace {@link SpringBootApplication} oznamuje Springu, že se jedná o aplikaci typu Spring Boot a má použít výchozí konfiguraci všude, kde je to možné.
 */
@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        logger.info("Aplikace běží na adrese: http://localhost:{}", applicationContext.getEnvironment().getProperty("local.server.port"));
    }
}
