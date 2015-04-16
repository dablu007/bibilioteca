package com.twu.biblioteca;

/**
 * Created by dabluk on 16/04/15.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
//        books.add(new Book(1, "JAVA", "Herbert Schildt", "TMH"));
//        books.add(new Book(2, "J2EE", "Herbert Schildt", "SUN"));
//        books.add(new Book(3, "C++", "James Stourstrup", "TMH"));
//        books.add(new Book(4, "ORACLE", "Harish Gaur", "Oracle"));
    }


    public Book getBook(int bookNumber) throws BookNotFoundException    {
        for (int i = 0; i<books.size(); i++){
            if(books.get(i).getBookNo() == bookNumber){
                return books.get(i);
            }
        }
        throw new BookNotFoundException("Book with id "+ bookNumber + " not found");
    }
//
//    public Book getBook(int bookNumber) throws BookNotFoundException {
//        boolean flag = false;
//        int i;
//        for (i = 0; i < books.size(); i++) {
//            if ( books.get(i).getBookNo() == bookNumber){
//                flag = true;
//                break;
//
//            }
//        }
//        if (flag == true){
//            return books.get(i);
//
//        }
//        else{
//            throw new BookNotFoundException("Book not found");
//        }
//    }
}

