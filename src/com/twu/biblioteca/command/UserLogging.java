package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.User;
import com.twu.biblioteca.controller.UserManager;
import com.twu.biblioteca.view.Display;

/**
 * Created by dabluk on 24/04/15.
 */
public class UserLogging {
    private User userLoggedIn = null;
    public User checkLoginAndReturnUser(UserManager userManager, Login login, User user) {
        if (userManager.isLoggedIn()) {
            return userLoggedIn;
        }

        Display.enterLoginDetails();

        login.enterDetails();
        String libraryNo = login.getUserId();
        String password = login.getPassword();

        userLoggedIn = userManager.isValidUser(libraryNo, password);
        if (userLoggedIn == null) {
            Display.invalidPassword();
            return null;
        }

        return userLoggedIn;
    }
}
