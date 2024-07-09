package com.example.standardbankjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Standard Bank JWT Application.
 * This class serves as the entry point for the Spring Boot application.
 *
 * @author Cytrogen
 * @version 1.0
 * @since 2024-07-09
 */
@SpringBootApplication
public class StandardBankJWTApplication {

    /**
     * The main method which serves as the entry point for the application.
     * This method starts the Spring Boot application.
     *
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(StandardBankJWTApplication.class, args);
    }

}