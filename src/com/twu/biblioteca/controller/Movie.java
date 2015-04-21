package com.twu.biblioteca.controller;

import java.util.Date;

/**
 * Created by dabluk on 21/04/15.
 */
public class Movie implements IRentableObject {
    private String movieName;
    private Date yearOfRelease;
    private String directorName;
    private int movieRating;
    private boolean availability;

    public Movie(String movieName, Date yearOfRelease, int movieRating, String directorName) {
        this.movieName = movieName;
        this.yearOfRelease = yearOfRelease;
        this.movieRating = movieRating;
        this.directorName = directorName;
        this.availability = true;
    }

    public String getMoviename() {
        return movieName;
    }

    public boolean isValidForCheckout(String movieName) {
        return (this.movieName.equals(movieName) && this.availability == true);
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
