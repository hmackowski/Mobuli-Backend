package com.mobuli.service;
import com.mobuli.entity.Movie;
import java.util.List;

public interface MovieService {
    Movie findById(Long id);
    List<Movie> findAll();
    Movie save(Movie movie);
    void deleteById(Long id);
    // Add more methods as needed based on your application's requirements
}