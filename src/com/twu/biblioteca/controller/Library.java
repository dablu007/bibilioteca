package com.twu.biblioteca.controller;

/**
 * Created by dabluk on 16/04/15.
 */
import com.twu.biblioteca.command.ReturnBookCommand;

import java.beans.beancontext.BeanContextMembershipEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    private Map<RentableType,ArrayList<IRentableObject>> entityMap;
    public Library(){
        issuedHistories = new IssuedHistory();
        books = new ArrayList<Book>();
        movies = new ArrayList<Movie>();
        userDetails = new ArrayList<UserDetail>();
        irentableObjectList = new ArrayList<IRentableObject>();
        entityMap = new HashMap<RentableType, ArrayList<IRentableObject>>();
    }



    public void addUser(UserDetail user) {
        userDetails.add(user);
    }

    public ArrayList<UserDetail> getUserDetails() {
        return userDetails;
    }


    public void add(IRentableObject libraryObject) {
        if (!entityMap.containsKey(libraryObject.getType())){
            entityMap.put(libraryObject.getType(), new ArrayList<IRentableObject>());
        }

        ArrayList<IRentableObject> rentables = entityMap.get(libraryObject.getType());
        rentables.add(libraryObject);
    }

    public ArrayList<IRentableObject> getEntityList(RentableType rentableType) {
        return entityMap.get(rentableType);
    }

    private RentableType checktype(IRentableObject rentableObject) {
        return rentableObject.getType();
    }

//    public ArrayList<IRentableObject> getObjectList() {
//        return irentableObjectList;
//    }

    public IRentableObject checkoutEntity(IRentableObject rentableObject, String customerName){
        ArrayList<IRentableObject> rentableObjects = getEntityList(rentableObject.getType());
        for( IRentableObject object : rentableObjects ){
            if( isSimilarObjects( object , rentableObject ) ){
                IssueDetail issueDetail = new IssueDetail(customerName,object);
                issuedHistories.addIssueDetail(issueDetail);
                object.setAvailability(false);
                return object;
            }
        }
        return null;
    }

    private boolean isSimilarObjects(IRentableObject Firstobject, IRentableObject SecondObject) {
        return (Firstobject.gethashcode() == SecondObject.gethashcode() && Firstobject.isAvailable()) ;
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

    public IRentableObject isObjectNull(String no,RentableType type) {
        ArrayList<IRentableObject> entities = entityMap.get(type);
        for(IRentableObject object:entities){
            if(object.getObjectNo().equals(no)){
                return object;
            }
        }
        return null;
    }


}

