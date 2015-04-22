package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.view.Display;

import java.util.ArrayList;

/**
 * Created by dabluk on 22/04/15.
 */
public class ListMoivesCommand implements ICommand{
    private ArrayList<Movie> movies;
    private ArrayList<IRentableObject> rentableObjects;

    public ListMoivesCommand(Library library) {
        movies = new ArrayList<Movie>();
        this.rentableObjects = library.getObjectList();
    }
    @Override
    public void execute() {
        for(IRentableObject object: rentableObjects){
            if (object instanceof Movie){
                movies.add((Movie) object);
            }
        }

        Display.printMovieList();
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).isAvailable())
                System.out.println(movies.get(i));
        }
    }

}
