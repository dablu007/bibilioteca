package com.twu.biblioteca.controller;

import java.util.Date;

/**
 * Created by dabluk on 21/04/15.
 */
public class Movie implements IRentableObject {
    private String movieName;
    private Date dateOfRelease;
    private String directorName;
    private int movieRating;
    private boolean availability;
    private  String movieNo ;
    public Movie(String movieNo,String movieName, Date dateOfRelease, int movieRating, String directorName) {
        this.movieName = movieName;
        this.dateOfRelease = dateOfRelease;
        this.movieRating = movieRating;
        this.directorName = directorName;
        this.availability = true;
        this.movieNo = movieNo;
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

    @Override
    public String getObjectNo() {
        return movieNo;
    }

    @Override
    public int gethashcode() {
        return (int) movieName.hashCode()* dateOfRelease.hashCode()*directorName.hashCode()*movieRating*movieNo.hashCode();
    }

    @Override
    public boolean isAvailable() {
        return availability;
    }


    public String toString() {
        return String.format("%s%27s%7d%27s%37s", movieNo, movieName,movieRating,directorName,dateOfRelease);
    }
}
