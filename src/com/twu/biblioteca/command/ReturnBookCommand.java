package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.exception.BookNotFoundException;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
                Display.printToGetBookNo();
                int bookno = Integer.parseInt(input.readLine());
                Display.printToGetCustomerName();
                String name = input.readLine();
                if (library.returnBook(bookno,name)){
                    Display.printBookReturned();
                }
                else{
                    Display.printBookNotReturned();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
