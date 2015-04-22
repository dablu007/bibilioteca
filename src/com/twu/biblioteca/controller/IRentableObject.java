package com.twu.biblioteca.controller;

public interface IRentableObject {
    void setAvailability(boolean value);
    String getObjectNo();
    int gethashcode();
    boolean isAvailable();
    RentableType getType();
}
