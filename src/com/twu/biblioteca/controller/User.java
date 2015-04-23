package com.twu.biblioteca.controller;

/**
 * Created by dabluk on 21/04/15.
 */
public class User {
    private String userName;
    private String emailId;
    private String  phoneNo;
    private String libraryNo;
    private String password;


    public User(String libraryNo, String userName, String emailId, String phoneNo, String password) {
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.libraryNo = libraryNo;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getUserId() {
        return libraryNo;
    }

    public String getPassword() {
        return password;
    }
}
