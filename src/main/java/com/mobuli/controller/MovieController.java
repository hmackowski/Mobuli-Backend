package com.mobuli.controller;

import com.mobuli.entity.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public interface MovieController {

    public List<Movie> getAllMovies();
     Optional<Movie> addMovie(@RequestBody Movie movie);

    public ResponseEntity<Movie> updateWatchedStatus(@PathVariable long id, @RequestBody boolean newWatchedStatus);

}
