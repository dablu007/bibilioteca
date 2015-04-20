package com.twu.biblioteca.controller;

/**
 * Created by dabluk on 16/04/15.
 */
import com.twu.biblioteca.command.ReturnBookCommand;
import com.twu.biblioteca.exception.BookNotFoundException;

import java.util.ArrayList;

/**
 * Created by dabluk on 14/04/15.
 */
public class Library {

    private ArrayList<Book> books;
    private ArrayList<IssuedHistory> issuedHistories;
    private IssuedHistory issuedHistory;
    private ReturnBookCommand returnBookCommand;
    public Library(){
        issuedHistories = new ArrayList<IssuedHistory>();
        issuedHistory = new IssuedHistory();
        books = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks() {

        return books;
    }

    public IssuedHistory getIssuedHistory() {
        return issuedHistory;
    }

    public ArrayList<IssuedHistory> getIssuedHistories() {
        return issuedHistories;
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


    public Book Checkout(int index,String name) {
        if ( books.size() >= index) {
            for(Book book : books){
                if (book.getBookNo() == index && book.isAvailable() == true ){
                    book.setAvailability(false);
                    IssueDetail issueDetail = new IssueDetail(name,book);
                    issuedHistory.addIssueDetail(issueDetail);
                    issuedHistories.add(issuedHistory);
                    return book;
                }

            }
            return null;
        }
        else
            return null;

    }

}

