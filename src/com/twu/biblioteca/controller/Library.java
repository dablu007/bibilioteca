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
    private IssuedHistory issuedHistories;
    private ReturnBookCommand returnBookCommand;

    public Library(){
        issuedHistories = new IssuedHistory();
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


    public Book checkout(int bookno, String name) {
            for(Book book : books){
                if (book.getBookNo() == bookno && book.isAvailable() == true ){
                    book.setAvailability(false);
                    IssueDetail issueDetail = new IssueDetail(name,book);
                    issuedHistories.addIssueDetail(issueDetail);
                    return book;
                }

            }
            return null;
    }

    public IssueDetail getIssueDetail(int checkedOutBookNo) {
        return issuedHistories.getIssueDetail(checkedOutBookNo);
    }

    public boolean returnBook(int bookNo,String customerName) {
        IssueDetail issueDetail = getIssueDetail(bookNo);
        if (issueDetail == null)
            return false;
        return issueDetail.isForCustomer(customerName);
    }
}

