package com.mobuli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @Column(name = "Poster", length = 65535)
    private String poster;

    @Column(name = "Year")
    private int year;

    @Column(name = "Watched", nullable = false)
    private boolean watched;

    @Column(name = "imdbID", unique = true, length = 255)
    private String imdbID;

    @ManyToMany(mappedBy = "movies")
    private Set<User> users;
}
