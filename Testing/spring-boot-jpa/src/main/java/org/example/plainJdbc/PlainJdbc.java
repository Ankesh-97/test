package org.example.plainJdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("org.example.plainJdbc")
public class PlainJdbc implements CommandLineRunner {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(PlainJdbc.class, args);
        CommandLineRunner commandLineRunner = (s) -> System.out.println("Plain Jdbc Application started successfully!");
        commandLineRunner.run("Start");
    }

    @Override
    public void run(String... args) {
        System.out.println("Plain Jdbc Application started successfully!");
    }
}