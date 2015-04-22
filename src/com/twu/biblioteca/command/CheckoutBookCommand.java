package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.ICommand;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.controller.RentableType;
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
    public CheckoutBookCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            Display.printToGetBook();
            Display.printToGetBookNo();
            String bookno = (input.readLine());
            book = (Book)library.isObjectNull(bookno, RentableType.BOOK);
            Display.printToGetCustomerName();
            String name = input.readLine();
            if ( book == null){
                Display.printBookNotCheckedOut();
            }
            else {

                Book checkedoutBook = (Book) library.checkoutEntity(book, name);

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
