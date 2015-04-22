package com.twu.biblioteca.controller;

import com.twu.biblioteca.command.*;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 14/04/15.
 */
public class Main {
    public static void main(String args[]) throws ParseException {
        Library library = new Library();
        Book book;
        String expectedPattern;
        SimpleDateFormat dateFormat;
        Date inputDate;
        Movie movie;
        book = new Book("B1", "JAVA", "Herbert Schildt", "TMH");
        library.add(book);
        book = new Book("B2", "C", "Dennis Richie", "Sun");
        library.add(book);
        book = new Book("B3", "ORACLE", "Harish Gaur", "TMH");
        library.add(book);
        book = new Book("B4", "C++", "Herbert Schildt", "TMH");
        library.add(book);
        Display display = new Display(); //TODO:
        display.welcomeMessage();
        expectedPattern = "mm/dd/yyyy";
        dateFormat = new SimpleDateFormat(expectedPattern);
        String date = "14/07/2008";

        inputDate =  dateFormat.parse(date);
        movie = new Movie("Mov1","The Dark Night",inputDate,8,"Christopher Nolan");
        library.add(movie);

        movie = new Movie("Mov2","Fast and Furious 7",inputDate,7,"James Wan");
        library.add(movie);
        movie = new Movie("Mov3","The Dark Knight Rises",inputDate,9,"Christopher Nolan");
        library.add(movie);


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
            ListMoivesCommand listMoivesCommand = new ListMoivesCommand(library);
            CheckoutMovieCommand checkoutMovieCommand = new CheckoutMovieCommand(library);
            Menu options = new Menu();

            options.addCommand(1, listbooks);
            options.addCommand(2, getbookdetail);
            options.addCommand(3, checkoutBook);
            options.addCommand(4, returnbook);
            options.addCommand(5,listMoivesCommand);
            options.addCommand(6,checkoutMovieCommand);
            options.addCommand(7,exit);

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
