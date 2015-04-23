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
    public CheckoutBookCommand(Library library,ManageUser manageUser) {
        this.library = library;
        this.manageUser =manageUser;
    }

    @Override
    public void execute() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
//            Display.printTogetUserID();
//            String libraryNo = input.readLine();
//            Display.printTogetPassword();
//            String password = input.readLine();
//            User user= manageUser.getValidUser(libraryNo, password);
//            if ( user == null)  {
//                Display.printInvalidPassword();
//                return;
//            }




            Display.printToGetBook();
            Display.printToGetBookNo();
            String bookno = (input.readLine());

            IRentableObject book = library.getRentableObject(bookno, RentableType.BOOK);

            if (book == null) {
                Display.printBookNotCheckedOut();

            } else {

                IRentableObject checkedoutBook = library.checkoutEntity(book, "");
                if (checkedoutBook != null) {
                    Display.printBookCheckedOut();
                } else
                    Display.printBookNotCheckedOut();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
