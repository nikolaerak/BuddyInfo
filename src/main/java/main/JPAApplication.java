package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Optional;

@SpringBootApplication
public class JPAApplication {

    private static final Logger log = LoggerFactory.getLogger(JPAApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JPAApplication.class);
        app.run(JPAApplication.class);
    }
}