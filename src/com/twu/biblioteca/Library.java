package com.twu.biblioteca;

/**
 * Created by dabluk on 16/04/15.
 */
import com.twu.biblioteca.exception.BookNotFoundException;

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


    public void addBooks(Book book){
            books.add(book);
    }


    public Book getBook(int bookNumber) throws BookNotFoundException {
        for (int i = 0; i<books.size(); i++){
            if(books.get(i).getBookNo() == bookNumber){
                return books.get(i);
            }
        }
        throw new BookNotFoundException("Book with id "+ bookNumber + " not found");
    }
    public int BookAvilabilityForCheckout(int bookno){
        int i;
        for ( i = 0; i < books.size(); i++){
            if ( books.get(i).getBookNo() == bookno && books.get(i).isAvailability() == true){
                books.get(i).setAvailability(false);
                return 1;
            }
        }
        return 0;
    }

}

