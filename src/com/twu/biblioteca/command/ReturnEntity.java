package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.controller.RentableType;
import com.twu.biblioteca.controller.User;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 24/04/15.
 */
public class ReturnEntity {

    public void returnEntity(User userLoggedIn, Library library, RentableType type){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            Display.enterDetailsOfEntity(type);
            Display.EnterIdOfEntity(type);
            String bookno = (input.readLine());
            String name = userLoggedIn.getUserName();
            Book book = (Book)library.getRentableObject(bookno, type);

            if (library.returnRentableObject(book,name)){
                book.setAvailability(true);
                Display.successfullyReturnedEntity(type);
            }
            else {
                Display.unsuccessfullEntityToReturn(type);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
