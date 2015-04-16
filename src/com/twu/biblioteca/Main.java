package com.twu.biblioteca;

import com.twu.biblioteca.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 14/04/15.
 */
public class Main {
    public static void main(String args[]){
        Library library = new Library();
        library.addBooks();
        Display display = new Display();
        display.welcomeMessage();

        while (true){
            display.printMenu();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your Choice");
            int choice;

            ListBooksCommand listbooks = new ListBooksCommand(library);
            GetBookDetail getbookdetail = new GetBookDetail(library);

            Menu options = new Menu();

            options.addCommand(1, listbooks);
            options.addCommand(2, getbookdetail);

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
