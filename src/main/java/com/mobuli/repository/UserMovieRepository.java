package com.mobuli.repository;

import com.mobuli.entity.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {
}
