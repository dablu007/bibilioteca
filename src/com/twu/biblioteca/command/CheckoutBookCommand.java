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
    private UserManager userManager;
    private Login login;
    private boolean exitCheckout = false;
    private UserLogging userLogging;
    private User user = null;
    private PrintUserDetails printUserDetails;
    private CheckOut checkout;

    public CheckoutBookCommand(Library library, UserManager userManager) {
        this.library = library;
        this.userManager = userManager;
        login = new Login();
        userLogging = new UserLogging();
        printUserDetails = new PrintUserDetails();
        checkout = new CheckOut();
    }

    @Override
    public void execute() {
//        boolean isLoggedIn = checkAndDoLogin();
//
//        if (!isLoggedIn)    {
//            return;
//        }
//        printUserDetails(user);
//        checkoutBook(user);
        User userLoggedIn = userLogging.checkLoginAndReturnUser(userManager, login, user);
        if (userLoggedIn == null)
            return;
        printUserDetails.printDetails(userLoggedIn);
        checkout.checkoutEntity(userLoggedIn, library, RentableType.BOOK);


    }
}

//    private boolean checkAndDoLogin() {
//        if (userManager.isLoggedIn()) {
//            return true;
//        }
//
//        Display.enterLoginDetails();
//
//        login.enterDetails();
//        String libraryNo = login.getUserId();
//        String password = login.getPassword();
//
//        this.user = userManager.isValidUser(libraryNo, password);
//
//        if (user == null) {
//            Display.invalidPassword();
//            return false;
//        }
//
//        return true;
//    }
//
//    private void printUserDetails(User user) {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//
//        // TODO : probably a very confusing user flow
//
//        Display.printUserOption();
//        try {
//            String option = input.readLine();
//            if (option.equals("N")){
//                return;
//            }
//
//            System.out.print(user);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void checkoutBook(User user) {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        Display.printToGetBook();
//        Display.getBookNo();
//        String bookno = null;
//        try {
//            bookno = (input.readLine());
//            IRentableObject book = library.getRentableObject(bookno, RentableType.BOOK);
//
//            if (book == null) {
//                Display.bookNotCheckedOut();
//                return;
//
//            }
//
//            //TODO for changing username to user object
//            IRentableObject checkedoutBook = library.checkout(book, user.getUserName());
//            if (checkedoutBook != null) {
//                    Display.bookCheckedOut();
//                    return;
//            }
//            else {
//                    Display.bookNotCheckedOut();
//                    return;
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
