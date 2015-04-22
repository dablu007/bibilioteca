package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 20/04/15.
 */
public class ReturnBookCommand implements ICommand {
    private Library library;

    public ReturnBookCommand(Library library) {
        this.library  = library;
    }

    @Override
    public void execute()  {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            try {
                Display.printToGetBook();
                Display.printToGetBookNo();
                String bookno = (input.readLine());

                Display.printToGetCustomerName();
                String name = input.readLine();
                Book book = (Book)library.isObjectNull(bookno,RentableType.BOOK);
                if (library.returnRentableObject(book,name)){
                    book.setAvailability(true);
                    Display.printBookReturned();
                }
                else{
                    Display.printBookNotReturned();
                }

            }
                catch (IOException e) {
                e.printStackTrace();
            }

    }
}
