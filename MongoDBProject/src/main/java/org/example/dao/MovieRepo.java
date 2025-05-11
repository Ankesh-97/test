package org.example.dao;

import org.example.Entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends MongoRepository<Movie, String> {

}
