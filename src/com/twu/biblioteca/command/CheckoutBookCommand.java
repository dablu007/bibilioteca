package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 17/04/15.
 */

public class CheckoutBookCommand implements ICommand {
    private Library library;
    private Book book;
    private ManageUser manageUser;
    private Login login;
    private User user = null;
    private boolean exitCheckout = false;

    public CheckoutBookCommand(Library library, ManageUser manageUser) {
        this.library = library;
        this.manageUser =manageUser;
        login = new Login();
    }

    @Override
    public void execute() {
        boolean isLoggedIn = checklogin();

        if (!isLoggedIn)    {
            return;
        }

        printUserDetails(user);

        if (exitCheckout)
            return;

        checkoutBook(user);
    }

    private boolean checklogin() {
        if (manageUser.isLoggedIn()) {
            return true;
        }

        Display.printLogin();

        login.enterDetails();
        String libraryNo = login.getUserId();
        String password = login.getPassword();

        this.user = manageUser.isValidUser(libraryNo, password);

        if (user == null) {
            Display.printInvalidPassword();
            return false;
        }

        return true;
    }

    private void printUserDetails(User user) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // TODO : probably a very confusing user flow

        Display.printUserOption();
        try {
            String option = input.readLine();
            if (option.equals("N")){
                exitCheckout = true;
                return;
            }

            System.out.print(user);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkoutBook(User user) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Display.printToGetBook();
        Display.printToGetBookNo();
        String bookno = null;
        try {
            bookno = (input.readLine());
            IRentableObject book = library.getRentableObject(bookno, RentableType.BOOK);

            if (book == null) {
                Display.printBookNotCheckedOut();
                return;

            }

            //TODO for changing username to user object
            IRentableObject checkedoutBook = library.checkout(book, user.getUserName());
            if (checkedoutBook != null) {
                    Display.printBookCheckedOut();
                    return;
            }
            else {
                    Display.printBookNotCheckedOut();
                    return;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
