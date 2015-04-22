package com.twu.biblioteca.controller;

/**
 * Created by dabluk on 16/04/15.
 */
import com.twu.biblioteca.command.ReturnBookCommand;
import com.twu.biblioteca.exception.BookNotFoundException;
import org.junit.Test;

import java.beans.beancontext.BeanContextMembershipEvent;
import java.util.ArrayList;

/**
 * Created by dabluk on 14/04/15.
 */
public class Library {

    private ArrayList<Book> books;
    private ArrayList<Movie> movies;
    private ArrayList<UserDetail> userDetails ;
    private IssuedHistory issuedHistories;
    private ReturnBookCommand returnBookCommand;
    private BeanContextMembershipEvent moviesList;
    private ArrayList<IRentableObject> irentableObjectList;
    public Library(){
        issuedHistories = new IssuedHistory();
        books = new ArrayList<Book>();
        movies = new ArrayList<Movie>();
        userDetails = new ArrayList<UserDetail>();
        irentableObjectList = new ArrayList<IRentableObject>();
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

//    public IssueDetail getIssueDetail(int checkedOutBookNo) {
//        return issuedHistories.getIssueDetail(checkedOutBookNo);
//        return null;
//    }

//    public boolean returnBook(int bookNo,String customerName) {
//        IssueDetail issueDetail = getIssueDetail(bookNo);
//        if (issueDetail == null)
//            return false;
//        return issueDetail.isForCustomer(customerName);
//    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public ArrayList<Movie> getMoviesList() {
        if (movies.size() == 0)
            return null;
        return movies;
    }

    public Movie checkoutMovie(String movieName) {
        ArrayList<Movie> movies = getMoviesList();
        for (Movie movie:movies){
            if (movie.isValidForCheckout(movieName) ){
                movie.setAvailability(false);
                return movie;
            }
        }
        return null;
    }

    public void addUser(UserDetail user) {
        userDetails.add(user);
    }

    public ArrayList<UserDetail> getUserDetails() {
        return userDetails;
    }


    public void add(IRentableObject libraryObject) {
        irentableObjectList.add(libraryObject);
    }

    public ArrayList<IRentableObject> getObjectList() {
        return irentableObjectList;
    }
    public IRentableObject checkoutObject(IRentableObject rentableObject,String customerName){
        ArrayList<IRentableObject> rentableObjects = getObjectList();
        for(IRentableObject object:rentableObjects){
            if(object.gethashcode() == rentableObject.gethashcode()){
                IssueDetail issueDetail = new IssueDetail(customerName,object);
                issuedHistories.addIssueDetail(issueDetail);
                object.setAvailability(false);
                return object;
            }
        }
        return null;
    }
    public IssueDetail getIssueDetail(IRentableObject rentableObject) {
        return issuedHistories.getIssueDetail(rentableObject);
    }

    public boolean returnRentableObject(IRentableObject rentableObject, String customerName) {
        IssueDetail issueDetail = getIssueDetail(rentableObject);
        if (issueDetail == null)
            return false;
        return issueDetail.isForCustomer(customerName);
    }
}

