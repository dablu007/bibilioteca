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
                Display.printToGetBook();
                Display.printToGetBookNo();
                int bookno = Integer.parseInt(input.readLine());
                Display.printToGetBookName();
                String bookname = input.readLine();
                Display.printToGetBookAuthor();
                String bookauthor = input.readLine();
                Display.printToGetBookPublication();
                String bookPublication = input.readLine();
                Display.printToGetCustomerName();
                String name = input.readLine();
                Book book = new Book(bookno,bookname,bookauthor,bookPublication);
                if (library.returnRentableObject(book,name)){
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
