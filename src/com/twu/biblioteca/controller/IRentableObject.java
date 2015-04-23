package com.twu.biblioteca.controller;

public interface IRentableObject {
    void setAvailability(boolean value);
    String getId();
    boolean isAvailable();
    RentableType getType();

}
