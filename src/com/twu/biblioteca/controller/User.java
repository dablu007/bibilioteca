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
    private boolean isLoggedIn;

    public User(String libraryNo, String userName, String emailId, String phoneNo, String password) {
        this.userName = userName;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.libraryNo = libraryNo;
        this.password = password;
        this.isLoggedIn = false;
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

    public boolean isLoggedIn(){
        return isLoggedIn;
    }

    @Override
    public String toString() {
        return String.format("%s%20s%27s%17s",userName,emailId ,phoneNo,libraryNo);
    }
}
