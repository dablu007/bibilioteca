package com.twu.biblioteca.controller;

import com.twu.biblioteca.command.*;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 14/04/15.
 */
public class Main {
    public static void main(String args[]){
        Library library = new Library();
        Book book;
        book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        library.add(book);
        book = new Book(2, "C", "Dennis Richie", "Sun");
        library.add(book);
        book = new Book(3, "ORACLE", "Harish Gaur", "TMH");
        library.add(book);
        book = new Book(4, "C++", "Herbert Schildt", "TMH");
        library.add(book);
        Display display = new Display(); //TODO:
        display.welcomeMessage();

        while (true){
            display.printMenu();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your Choice");
            int choice;

            ListBooksCommand listbooks = new ListBooksCommand(library);
            GetBookDetailCommand getbookdetail = new GetBookDetailCommand(library);
            CheckoutBookCommand checkoutBook = new CheckoutBookCommand(library);
            ExitCommand exit = new ExitCommand();
            ReturnBookCommand returnbook = new ReturnBookCommand(library);

            Menu options = new Menu();

            options.addCommand(1, listbooks);
            options.addCommand(2, getbookdetail);
            options.addCommand(3, checkoutBook);
            options.addCommand(4, returnbook);
            options.addCommand(5,exit);

            try {
                choice = Integer.parseInt(input.readLine());
                ICommand command = options.getCommand(choice);
                command.execute();

            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
