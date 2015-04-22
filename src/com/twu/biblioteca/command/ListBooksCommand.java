package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;

import java.util.ArrayList;

/**
 * Created by dabluk on 15/04/15.
 */
public class ListBooksCommand implements ICommand {
    private  ArrayList<Book> books;
    private ArrayList<IRentableObject> rentableObjects;
    public ListBooksCommand(Library library) {
        books = new ArrayList<Book>();
    //    this.books = library.getBooks();
        this.rentableObjects = library.getObjectList();
    }
    @Override
    public void execute() {
        for(IRentableObject object: rentableObjects){
            if (object instanceof Book){
                books.add((Book) object);
            }
        }
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