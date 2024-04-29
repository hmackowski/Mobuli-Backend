package com.mobuli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or another suitable strategy
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @Column(name = "Poster", length = 65535) // TEXT in MySQL has a maximum length of 65535 characters
    private String poster;

    @Column(name = "Year")
    private int year; // Changed to String to match your initial structure, otherwise use Integer or a Date type

    @Column(name = "Watched", nullable = false)
    private boolean watched;

    @Column(name = "imdbID", unique = true, length = 255)
    private String imdbID;

    /*@Column(name = "genre", length = 255)
    private String genre;*/

}
