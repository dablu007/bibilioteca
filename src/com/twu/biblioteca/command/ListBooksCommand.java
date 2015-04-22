package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.view.Display;

import java.util.ArrayList;

/**
 * Created by dabluk on 15/04/15.
 */
public class ListBooksCommand implements ICommand {
    private  ArrayList<IRentableObject> books;
    private Library library;

    public ListBooksCommand(Library library) {
        this.library = library;
    }
    @Override
    public void execute() {
        books = library.getEntityList(RentableType.BOOK);

        Display.printBooksList();

        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).isAvailable())
            System.out.println(books.get(i));
        }
    }

    public void printbook(ICanPrint outputWriterMock, int index) {
        outputWriterMock.write(String.valueOf(books.get(index)));
    }
}