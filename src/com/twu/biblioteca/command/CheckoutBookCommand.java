package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.ICommand;
import com.twu.biblioteca.controller.IssuedHistory;
import com.twu.biblioteca.controller.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dabluk on 17/04/15.
 */
public class CheckoutBookCommand implements ICommand {

    private ArrayList<Book> books;
    private Library library = new Library();
    private Book checkoutOutput;

    public CheckoutBookCommand(Library library) {
        books = new ArrayList<Book>();
        this.books = library.getBooks();
        this.library = library;
    }


    @Override
    public void execute() {


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        IssuedHistory issuedHistory = new IssuedHistory();
        int bookno = 0;
        try {
            System.out.println("Enter the Book Number for Checkout");
            bookno = Integer.parseInt(input.readLine());
            System.out.println("Enter the Name of customer");
            String name = input.readLine();
            checkoutOutput = library.Checkout(bookno,name);

            if(checkoutOutput != null) {
                System.out.println("Thank you! Enjoy the book");
            }
            else
                System.out.println("That Book is Not Avilable");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Book getCheckoutOutput() {
        return checkoutOutput;
    }
}
