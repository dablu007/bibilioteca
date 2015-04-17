package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dabluk on 17/04/15.
 */
public class CheckoutBook implements ICommand{

    private ArrayList<Book> books;
    private Library library = new Library();
    private int checkoutOutput;
    public CheckoutBook(Library library) {
        books = new ArrayList<Book>();
        this.books = library.getBooks();

    }


    @Override
    public void execute() {
            for (int i = 0; i < books.size() ; i++) {
                library.addBooks(books.get(i));
            }
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //    System.out.println("Enter the Book Number for Checkout");
        //    int bookno = Integer.parseInt(input.readLine());
            checkoutOutput = library.BookAvilabilityForCheckout(1);
        //    checkoutOutput = library.BookAvilabilityForCheckout(1);

    }

    public int getCheckoutOutput() {
        return checkoutOutput;
    }
}
