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
    public String getId() {
        return bookNo;
    }

    public boolean isAvailable() {
        return availability;
    }

    @Override
    public RentableType getType() {
        return RentableType.BOOK;
    }

    @Override
    public String toString() {
        return String.format("%s%20s%27s%17s", bookNo, bookName,bookAuthor,bookPublication);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (availability != book.availability) return false;

        if (!bookNo.equals(book.bookNo)) return false;
        if (!bookName.equals(book.bookName)) return false;
        if (!bookAuthor.equals(book.bookAuthor)) return false;
        return bookPublication.equals(book.bookPublication);

    }

    @Override
    public int hashCode() {
        int result = bookNo.hashCode();
        result = 31 * result + bookName.hashCode();
        result = 31 * result + bookAuthor.hashCode();
        result = 31 * result + bookPublication.hashCode();
        result = 31 * result + (availability ? 1 : 0);
        return result;
    }
}
