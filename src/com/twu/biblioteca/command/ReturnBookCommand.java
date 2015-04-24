package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;

/**
 * Created by dabluk on 20/04/15.
 */
public class ReturnBookCommand implements ICommand {
    private Library library;
    private UserManager userManager;
    private Login login;
    private UserLogin userLogin;
    private PrintUserDetails printUserDetails;

    public ReturnBookCommand(Library library, UserManager userManager) {
        this.library  = library;
        this.userManager = userManager;
        login = new Login();
        userLogin = new UserLogin();
        printUserDetails = new PrintUserDetails();
        returnEntity = new ReturnEntity();
    }

    private ReturnEntity returnEntity;

    @Override
    public void execute()  {
            User userLoggedIn = userLogin.getALoggedInUser(userManager, login);
            if(userLoggedIn == null) {
                return;
            }

            printUserDetails.printDetails(userLoggedIn);

            returnEntity.returnEntity(userLoggedIn, library, RentableType.BOOK);


    }
}
