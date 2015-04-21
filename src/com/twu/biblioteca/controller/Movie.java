package com.twu.biblioteca.controller;

import java.util.Date;

/**
 * Created by dabluk on 21/04/15.
 */
public class Movie {
    private String movieName;
    private Date yearOfRelease;
    private String directorName;
    private int movieRating;

    public Movie(String movieName, Date yearOfRelease, int movieRating, String directorName) {
        this.movieName = movieName;
        this.yearOfRelease = yearOfRelease;
        this.movieRating = movieRating;
        this.directorName = directorName;
    }
}
