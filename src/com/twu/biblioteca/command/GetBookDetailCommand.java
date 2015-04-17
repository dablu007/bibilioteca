package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.ICanPrint;
import com.twu.biblioteca.ICommand;
import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by dabluk on 15/04/15.
 */
public class GetBookDetailCommand implements ICommand {
    private ArrayList<Book> books;
    public GetBookDetailCommand(Library library) {
        books = new ArrayList<Book>();
        this.books = library.getBooks();
    }
    
    @Override
    public void execute() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Book Number for getting Details");
            int bookno = Integer.parseInt(input.readLine());
            System.out.println("Book No.                Book Name");
            for (int i = 0; i < books.size(); i++) {
                if ( books.get(i).getBookNo() == bookno){
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
