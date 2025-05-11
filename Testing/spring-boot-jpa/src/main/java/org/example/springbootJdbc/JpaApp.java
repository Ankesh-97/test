package org.example.springbootJdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApp {

    public static void main(String[] args) {
        SpringApplication.run(JpaApp.class, args);
        System.out.println("JPA Application started successfully!");
    }
}
