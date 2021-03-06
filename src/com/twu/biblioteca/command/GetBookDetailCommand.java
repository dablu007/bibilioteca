package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by dabluk on 15/04/15.
 */
public class GetBookDetailCommand implements ICommand {
    private ArrayList<Book> books;
    private ArrayList<IRentableObject> rentableObjects;
    public GetBookDetailCommand(Library library) {
        books = new ArrayList<Book>();
        this.rentableObjects = library.getEntityList(RentableType.BOOK);
    }
    
    @Override
    public void execute() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        for(IRentableObject object: rentableObjects){
            if (object instanceof Book){
                books.add((Book) object);
            }
        }
        try {
            Display.getBookNo();
            String bookno = (input.readLine());
            Display.printBook();
            for (int i = 0; i < books.size(); i++) {
                if ( books.get(i).getBookNo().equals(bookno)){
                    System.out.println(books.get(i));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getaBook(ICanPrint outputWriterMock, int index) {
        outputWriterMock.write(String.valueOf(books.get(index)));
    }
}
