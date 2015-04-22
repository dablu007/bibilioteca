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
            if(object.gethashcode() == rentableObject.gethashcode() && object.isAvailable() ){
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

    public IRentableObject getObjectDetail(String no) {
        for(IRentableObject object:irentableObjectList){
            if(object.getObjectNo().equals(no)){
                return object;
            }
        }
        return null;
    }
}

