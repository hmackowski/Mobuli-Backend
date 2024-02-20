package com.mobuli.controller;

import com.mobuli.entity.Movie;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface MovieController {

    public List<Movie> getAllMovies();
    public String testController();
}
