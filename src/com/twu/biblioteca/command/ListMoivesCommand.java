package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.view.Display;

import java.util.ArrayList;

/**
 * Created by dabluk on 22/04/15.
 */
public class ListMoivesCommand implements ICommand{
    private ArrayList<IRentableObject> movies;
    private ArrayList<IRentableObject> rentableObjects;
    private Library library;
    public ListMoivesCommand(Library library) {
        this.library = library;
        this.rentableObjects = library.getEntityList(RentableType.MOVIE);
    }
    @Override
    public void execute() {
        movies = library.getEntityList(RentableType.MOVIE);
        Display.printMovieList();
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).isAvailable())
                System.out.println(movies.get(i));
        }
    }

}
