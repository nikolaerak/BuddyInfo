package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JPAApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JPAApplication.class);
        app.run(JPAApplication.class);
    }
}