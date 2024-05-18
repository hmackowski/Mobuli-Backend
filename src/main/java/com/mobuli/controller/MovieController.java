package com.mobuli.controller;

import com.mobuli.entity.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public interface MovieController {

    public List<Movie> getAllMovies();

    Optional<Movie> addMovie(@RequestBody Movie movie);

    ResponseEntity<Movie> getMovieByImdbID(String imdbID);

    public ResponseEntity<Movie> updateWatchedStatus(@PathVariable long id, @RequestBody boolean newWatchedStatus);

    public Optional<Movie> deleteByImdbID(String imdbID);

    public List<Movie> getAllUserMovies(int userID);
    public void addMovieToUser(@PathVariable Long userId, @RequestParam String imdbID);

}
