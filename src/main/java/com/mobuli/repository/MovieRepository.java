package com.mobuli.repository;

import com.mobuli.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByImdbID(String imdbID);
    Optional<Movie> deleteByImdbID(String imdbID);
    @Query("SELECT m FROM Movie m JOIN m.users u WHERE u.id = :userId")
    List<Movie> findAllMoviesByUserId(@Param("userId") Long userId);
}
