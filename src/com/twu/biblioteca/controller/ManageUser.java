package com.twu.biblioteca.controller;

import java.util.ArrayList;

/**
 * Created by dabluk on 23/04/15.
 */
public class ManageUser {

    private ArrayList<User> users;
    private User emptyUser = null;
    private boolean isLoggedIn = false;
//    private ArrayList<User> cu
    public ManageUser() {
        users = new ArrayList<User>();
    }

    public void add(User user) {
        users.add(user);
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public User isValidUser(String libraryId, String password) {
        for (User user : users) {
            if( user.getUserId().equals(libraryId) && user.getPassword().equals(password))  {
                this.isLoggedIn = true;
                return user;
            }
        }

        return emptyUser;
    }


}
