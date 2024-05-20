package com.mobuli.service;

import com.mobuli.entity.Movie;
import com.mobuli.entity.User;
import com.mobuli.entity.UserMovie;
import com.mobuli.repository.MovieRepository;
import com.mobuli.repository.UserMovieRepository;
import com.mobuli.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:3000")
@Service
public class DefaultMovieService implements MovieService {


    private final MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMovieRepository userMovieRepository;

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
    public Optional<Movie> addMovie(Movie movie) {
        System.out.println("Saving movie to database.");
        return Optional.of(movieRepository.save(movie));
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie updateWatchedStatus(long id, boolean newWatchedStatus) {
        Movie movie = movieRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Movie not found with id: " + id));
        movie.setWatched(newWatchedStatus);
        return movieRepository.save(movie);
    }

    public Movie getMovieByImdbID(String imdbID) {
        return movieRepository.findByImdbID(imdbID).orElseThrow(() ->
                new EntityNotFoundException("Movie not found with imdbID: " + imdbID));
    }

    @Override
    public Optional<Movie> deleteByImdbID(String imdbID) {
        Optional<Movie> movie = movieRepository.findByImdbID(imdbID);
        movie.ifPresent(movieRepository::delete);
        return movie;
    }

    @Override
    public void getAllUserMovies(int userID) {

    }

    public void addMovieToUser(Long userId, String imdbID) {
   UserMovie userMovie = new UserMovie();
   userMovie.setUser(userId);
   userMovie.setMovieID(imdbID);
   userMovieRepository.save(userMovie);
        System.out.printf("User: %d added movie %s successfully.%n", userId, imdbID);
    }

    // Implement other methods as needed
}