package com.twu.biblioteca;

import com.twu.biblioteca.command.ExitCommand;
import com.twu.biblioteca.command.GetBookDetailCommand;
import com.twu.biblioteca.command.ListBooksCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 14/04/15.
 */
public class Main {
    public static void main(String args[]){
        Library library = new Library();
        Book book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        library.addBooks(book);
        Display display = new Display(); //TODO:
        display.welcomeMessage();

        while (true){
            display.printMenu();
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your Choice");
            int choice;

            ListBooksCommand listbooks = new ListBooksCommand(library);
            GetBookDetailCommand getbookdetail = new GetBookDetailCommand(library);
            ExitCommand exit = new ExitCommand();

            Menu options = new Menu();

            options.addCommand(1, listbooks);
            options.addCommand(2, getbookdetail);
            options.addCommand(3,  exit);

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
