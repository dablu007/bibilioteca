package com.twu.biblioteca.controller;

import java.util.ArrayList;

/**
 * Created by dabluk on 23/04/15.
 */
public class UserManager {

    private ArrayList<User> users;

    private User emptyUser = null;

    private User currentlyLoggedInUser = null;

    public UserManager() {
        users = new ArrayList<User>();
    }

    public void add(User user) {
        users.add(user);
    }

    public boolean isLoggedIn() {
        return currentlyLoggedInUser != null;
    }

    public User getCurrentlyLoggedInUser()  {
        return currentlyLoggedInUser;
    }

    public User login(String libraryId, String password) {

        for (User user : users) {
            if( user.getUserId().equals(libraryId) && user.getPassword().equals(password))  {
                this.currentlyLoggedInUser = user;
                return user;
            }
        }

        return emptyUser;
    }


}
