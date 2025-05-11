package org.example;

import org.example.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoDbApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MovieService movieService = new MovieService();
        movieService.createMovie();
    }
}