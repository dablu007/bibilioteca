package com.twu.biblioteca.controller;

/**
 * Created by dabluk on 14/04/15.
 */
public class Book implements IRentableObject {
    private int bookNo;
    private String bookName;
    private String bookAuthor;
    private String bookPublication;
    private boolean availability;

    public Book(int bookNo, String bookName, String bookAuthor, String bookPublication){
        this.bookName = bookName;
        this.bookNo = bookNo;
        this.bookAuthor = bookAuthor;
        this.bookPublication = bookPublication;
        this.availability = true;
    }

    public  int getBookNo() {
        return bookNo;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isAvailable() {
        return availability;
    }

    @Override
    public String toString() {
        return String.format("%d%27s", bookNo, bookName);
    }


    public int gethashcode() {
        return (int) bookNo*bookAuthor.hashCode()*bookName.hashCode()*bookPublication.hashCode();
    }


}
