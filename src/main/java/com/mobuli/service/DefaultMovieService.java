package com.mobuli.service;

import com.mobuli.entity.Movie;
import com.mobuli.entity.User;
import com.mobuli.repository.MovieRepository;
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

    @Override
    public void addMovieToUser(Long userId, String imdbID) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Movie> movieOptional = movieRepository.findByImdbID(imdbID);

        if (userOptional.isPresent() && movieOptional.isPresent()) {
            User user = userOptional.get();
            Movie movie = movieOptional.get();
            user.getMovies().add(movie);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User or Movie not found");
        }
    }

    // Implement other methods as needed
}