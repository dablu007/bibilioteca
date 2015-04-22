package com.twu.biblioteca.controller;

/**
 * Created by dabluk on 17/04/15.
 */
public class IssueDetail {
    private String customerName;
    private IRentableObject rentableObject;

    public IssueDetail(String name, IRentableObject rentableObject) {
        this.customerName = name;
        this.rentableObject = rentableObject;

    }

    public IRentableObject getRentableObject() {
        return rentableObject;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean isForCustomer(String customerName) {
        return customerName !=null && customerName.equals(this.customerName);
    }
}
