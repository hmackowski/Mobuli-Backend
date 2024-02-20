package com.mobuli.controller;

import com.mobuli.entity.Movie;
import com.mobuli.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class DefaultMovieController implements MovieController {
    private final MovieService movieService;

    @Autowired
    public DefaultMovieController(MovieService movieService){

        this.movieService = movieService;
    }
     @GetMapping("/list")
     public List<Movie> getAllMovies() {
         System.out.println("Retrieving all movies!");
        return movieService.findAll();
     }

    @GetMapping("/test")
    public String testController() {
        System.out.println("Test in progess!");
        return "Controller is working";
    }


}
