package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by dabluk on 14/04/15.
 */
public class Library {
    private ArrayList<Book> books;

    public Library(){

        books = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBooks(){
        books.add(new Book(1, "JAVA", "Herbert Schildt", "TMH"));
        books.add(new Book(2, "J2EE", "Herbert Schildt", "SUN"));
        books.add(new Book(3, "C++", "James Stourstrup", "TMH"));
        books.add(new Book(4, "ORACLE", "Harish Gaur", "Oracle"));
    }


}
