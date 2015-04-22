package com.twu.biblioteca.controller;

/**
 * Created by dabluk on 14/04/15.
 */
public class Book implements IRentableObject {
    private String bookNo;
    private String bookName;
    private String bookAuthor;
    private String bookPublication;
    private boolean availability;

    public Book(String bookNo, String bookName, String bookAuthor, String bookPublication){
        this.bookName = bookName;
        this.bookNo = bookNo;
        this.bookAuthor = bookAuthor;
        this.bookPublication = bookPublication;
        this.availability = true;
    }

    public  String getBookNo() {
        return bookNo;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String getObjectNo() {
        return bookNo;
    }

    public boolean isAvailable() {
        return availability;
    }

    @Override
    public String toString() {
        return String.format("%s%20s%27s%17s", bookNo, bookName,bookAuthor,bookPublication);
    }


    public int gethashcode() {
        return (int) bookNo.hashCode()*bookAuthor.hashCode()*bookName.hashCode()*bookPublication.hashCode();
    }


}
