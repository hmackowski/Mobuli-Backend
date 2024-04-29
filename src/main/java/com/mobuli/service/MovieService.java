package com.mobuli.service;

import com.mobuli.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie findById(Long id);

    List<Movie> findAll();

    Optional<Movie> addMovie(Movie movie);

    void deleteById(Long id);

    public Movie updateWatchedStatus(long id, boolean newWatchedStatus);

    Movie getMovieByImdbID(String imdbId);

    Optional<Movie> deleteByImdbID(String imdbID);

}