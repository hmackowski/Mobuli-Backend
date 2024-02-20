package com.mobuli.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movies {
    @Id
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

    @Column(name = "genre", length = 255)
    private String genre;

}
