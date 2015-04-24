package com.twu.biblioteca.controller;

/**
 * Created by dabluk on 16/04/15.
 */
import com.twu.biblioteca.command.LoginDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dabluk on 14/04/15.
 */
public class Library {
    private IssuedHistory issuedHistories;
    private Map<RentableType,ArrayList<IRentableObject>> entityMap;
    private LoginDetails loginDetail;
    private ArrayList<LoginDetails> loginDetails;

    private static IRentableObject emptyEntityResult = null;

    public Library(){
        issuedHistories = new IssuedHistory();
        entityMap = new HashMap<RentableType, ArrayList<IRentableObject>>();
        loginDetails = new ArrayList<LoginDetails>();
    }

    public void add(IRentableObject libraryObject) {
        if (!entityMap.containsKey(libraryObject.getType())){
            entityMap.put(libraryObject.getType(), new ArrayList<IRentableObject>());
        }

        ArrayList<IRentableObject> rentables = entityMap.get(libraryObject.getType());
        rentables.add(libraryObject);

    }

    public ArrayList<IRentableObject> getEntityList(RentableType rentableType) {
        return new ArrayList<IRentableObject>(entityMap.get(rentableType));
    }


    public IRentableObject checkout(IRentableObject rentableObject, String customerName){
        ArrayList<IRentableObject> rentableObjects = getEntityList(rentableObject.getType());

        for( IRentableObject object : rentableObjects ){
            if( object.equals(rentableObject ) && object.isAvailable() ){
                IssueDetail issueDetail = new IssueDetail(customerName,object);
                issuedHistories.addIssueDetail(issueDetail);
                object.setAvailability(false);
                return object;
            }
        }
        return emptyEntityResult;
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

    public IRentableObject getRentableObject(String id, RentableType type) {
        ArrayList<IRentableObject> entities = entityMap.get(type);

        for(IRentableObject object:entities){
            if(object.getId().equals(id)){
                return object;
            }
        }
        return emptyEntityResult;
    }


    public ArrayList<LoginDetails> getLoginDetails() {
        return loginDetails;
    }




}

