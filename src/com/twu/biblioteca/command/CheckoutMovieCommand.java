package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.ICommand;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.controller.Movie;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 22/04/15.
 */
public class CheckoutMovieCommand implements ICommand {
    private Library library;

    public CheckoutMovieCommand(Library library) {
        this.library = library;
    }

    @Override
    public void execute() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            Display.printToGetMovie();
            Display.printToGetMovieNo();
            String movieno = (input.readLine());
            Movie movie = (Movie)library.getObjectDetail(movieno);
            Display.printToGetCustomerName();
            String name = input.readLine();
            if ( movie == null){
                Display.printMovieNotCheckedOut();
            }
            else {
                Movie checkedoutMovie = (Movie) library.checkoutObject(movie, name);

                if (checkedoutMovie != null) {
                    Display.printMovieCheckedOut();
                } else
                    Display.printMovieNotCheckedOut();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
