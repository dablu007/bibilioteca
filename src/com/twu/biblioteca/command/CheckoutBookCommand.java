package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.ICommand;
import com.twu.biblioteca.controller.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 17/04/15.
 */
public class CheckoutBookCommand implements ICommand {
    private Library library;

    public CheckoutBookCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the Book Number for checkout");
            int bookno = Integer.parseInt(input.readLine());
            System.out.println("Enter the Name of customer");
            String name = input.readLine();

            Book checkedoutBook = library.checkout(bookno, name);

            if(checkedoutBook != null) {
                System.out.println("Thank you! Enjoy the book");
            }
            else
                System.out.println("That Book is Not Avilable");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
