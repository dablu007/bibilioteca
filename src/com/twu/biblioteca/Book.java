package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by dabluk on 14/04/15.
 */
public class Book {
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

    public boolean isAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return String.format("%d%27s", bookNo, bookName);
    }


}
