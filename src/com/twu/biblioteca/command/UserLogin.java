package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.User;
import com.twu.biblioteca.controller.UserManager;
import com.twu.biblioteca.view.Display;

/**
 * Created by dabluk on 24/04/15.
 */
public class UserLogin {

    public User getALoggedInUser(UserManager userManager, Login login) {

        if (userManager.isLoggedIn()) {
            return userManager.getCurrentlyLoggedInUser();
        }

        Display.enterLoginDetails();
        login.enterDetails();

        String libraryNo = login.getUserId();
        String password = login.getPassword();

        User loggedInUser = userManager.login(libraryNo, password);

        if (loggedInUser == null) {
            Display.invalidPassword();
            return null;
        }

        return loggedInUser;
    }
}
