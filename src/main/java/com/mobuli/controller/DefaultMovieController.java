package com.mobuli.controller;

import com.mobuli.entity.Movie;
import com.mobuli.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/movie")
public class DefaultMovieController implements MovieController {
    private final MovieService movieService;

    @Autowired
    public DefaultMovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/list")
    public List<Movie> getAllMovies() {
        System.out.println("Retrieving all movies!");
        return movieService.findAll();
    }

    @PostMapping("/addMovie")
    public Optional<Movie> addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("/searchByImdbID")
    public ResponseEntity<Movie> getMovieByImdbID(String imdbID) {
        try {
            Movie movie = movieService.getMovieByImdbID(imdbID);
            return ResponseEntity.ok(movie);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PutMapping("/{id}/watched")
    public ResponseEntity<Movie> updateWatchedStatus(@PathVariable long id, @RequestBody boolean newWatchedStatus) {
        try {
            Movie updatedMovie = movieService.updateWatchedStatus(id, newWatchedStatus);
            return ResponseEntity.ok(updatedMovie);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @DeleteMapping("/deleteByimdbID")
    public Optional<Movie> deleteByImdbID(String imdbID) {
        return movieService.deleteByImdbID(imdbID);
    }

    @GetMapping("/test")
    public String test(){
        return "It's working";
    }

}
