package com.twu.biblioteca.controller;

/**
 * Created by dabluk on 21/04/15.
 */
public interface IRentableObject {
    void setAvailability(boolean value);
    String getObjectNo();
    int gethashcode();
    boolean isAvailable();
}
