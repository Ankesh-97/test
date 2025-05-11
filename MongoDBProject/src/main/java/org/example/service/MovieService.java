package org.example.service;

import org.bson.types.ObjectId;
import org.example.Entity.Movie;
import org.example.dao.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class MovieService {

    private MovieRepo movieRepo;

    public void createMovie() {
        movieRepo.saveAll(List.of(new Movie(ObjectId.get(),"The Godfather"), new Movie(ObjectId.get(),"The Dark Knight"), new Movie(ObjectId.get(),"Pulp Fiction")));
    }
}
