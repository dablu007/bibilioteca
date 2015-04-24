package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;

/**
 * Created by dabluk on 17/04/15.
 */

public class CheckoutBookCommand implements ICommand {
    private Library library;
    private UserManager userManager;
    private Login login;
    private UserLogin userLogin;
    private PrintUserDetails printUserDetails;
    private CheckOut checkout;

    public CheckoutBookCommand(Library library, UserManager userManager) {
        this.library = library;
        this.userManager = userManager;
        login = new Login();
        userLogin = new UserLogin();
        printUserDetails = new PrintUserDetails();
        checkout = new CheckOut();
    }

    @Override
    public void execute() {
        User userLoggedIn = userLogin.getALoggedInUser(userManager, login);

        if (userLoggedIn == null)
            return;

        printUserDetails.printDetails(userLoggedIn);
        checkout.checkoutEntity(userLoggedIn, library, RentableType.BOOK);
    }
}

