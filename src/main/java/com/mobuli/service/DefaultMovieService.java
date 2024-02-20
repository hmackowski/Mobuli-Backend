package com.mobuli.service;

import com.mobuli.entity.Movie;
import com.mobuli.DAO.MovieRepository;
import com.mobuli.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultMovieService implements MovieService{


    private final MovieRepository movieRepository;


    public DefaultMovieService(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElse(null);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    // Implement other methods as needed
}