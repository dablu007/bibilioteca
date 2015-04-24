package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;

/**
 * Created by dabluk on 22/04/15.
 */
public class CheckoutMovieCommand implements ICommand {
    private Library library;
    private UserManager userManager;
    private Login login;
    private UserLogging userLogging;
    private User user = null;
    private PrintUserDetails printUserDetails;
    private CheckOut checkout;
    public CheckoutMovieCommand(Library library,UserManager userManager) {
        this.library = library;
        this.userManager = userManager;
        login = new Login();
        userLogging = new UserLogging();
        printUserDetails = new PrintUserDetails();
        checkout = new CheckOut();
    }

    @Override
    public void execute() {
        User userLoggedIn = userLogging.checkLoginAndReturnUser(userManager, login, user);
        if(userLoggedIn == null)
            return;
        printUserDetails.printDetails(userLoggedIn);
        checkout.checkoutEntity(userLoggedIn,library,RentableType.MOVIE);


    }
}
