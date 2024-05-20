package com.mobuli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "user_movies")
@AllArgsConstructor
@NoArgsConstructor
public class UserMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_movie_id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long user;

    @Column(name = "movie_id", nullable = false)
    private String movieID;

    @Column(name = "added_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedAt = new Date();

    @Column(name = "watched")
    private boolean watched = false;
}
