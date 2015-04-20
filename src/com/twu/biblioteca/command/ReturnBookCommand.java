package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.exception.BookNotFoundException;

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
                System.out.println("Enter the Book Number You want to Return");
                int bookno = Integer.parseInt(input.readLine());
                System.out.println("Enter the Customer Name");
                String name = input.readLine();
                if (library.returnBook(bookno,name)){
                    System.out.println("Returned");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
