package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringSecurityProject {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ApplicationContext context = SpringApplication.run(SpringSecurityProject.class, args);
        System.out.println("Context: " + context.getApplicationName());
    }

}