package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.ICanPrint;
import com.twu.biblioteca.controller.ICommand;
import com.twu.biblioteca.controller.Library;

import java.util.ArrayList;

/**
 * Created by dabluk on 15/04/15.
 */
public class ListBooksCommand implements ICommand {
    private  ArrayList<Book> books;

    public ListBooksCommand(Library app) {
        books = new ArrayList<Book>();
        this.books = app.getBooks();
    }
    @Override
    public void execute() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("---------------Avilable Books------------------");
        System.out.println("Book No.                Book Name");
        System.out.println("_______                 _________");
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).isAvailable())
            System.out.println(books.get(i));
        }
    }

    public void printbook(ICanPrint outputWriterMock, int index) {
        outputWriterMock.write(String.valueOf(books.get(index)));
    }
}