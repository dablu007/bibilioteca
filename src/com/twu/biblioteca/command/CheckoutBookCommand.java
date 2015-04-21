package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.ICommand;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 17/04/15.
 */
public class CheckoutBookCommand implements ICommand {
    private Library library;

    public CheckoutBookCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            Display.printToGetBookNo();
            int bookno = Integer.parseInt(input.readLine());
            Display.printToGetCustomerName();
            String name = input.readLine();

            Book checkedoutBook = library.checkout(bookno, name);

            if(checkedoutBook != null) {
               Display.printBookCheckedOut();
            }
            else
               Display.printBookNotCheckedOut();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
