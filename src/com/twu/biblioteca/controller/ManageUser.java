package com.twu.biblioteca.controller;

import java.util.ArrayList;

/**
 * Created by dabluk on 23/04/15.
 */
public class ManageUser {

    private ArrayList<User> users;

    public ManageUser() {
        users = new ArrayList<User>();
    }

    public void add(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean isValidUser(String libraryId, String password) {
        for (User user : users) {
            if( user.getUserId().equals(libraryId) && user.getPassword().equals(password))  {
                return true;
            }
        }
        return false;
    }


}
