package com.virtualcave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class Application {

    /**
     * Main.
     * @param args the args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
