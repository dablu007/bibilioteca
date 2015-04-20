package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.exception.BookNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dabluk on 20/04/15.
 */
public class ReturnBookCommand implements ICommand {
    private ArrayList<Book> books;
    private IssuedHistory issuedHistory;
    private ArrayList<IssuedHistory> issuedHistories;
    private Library library = new Library();

    public ReturnBookCommand(Library library) {
        this.library  = library;
        issuedHistories = new ArrayList<IssuedHistory>();
    }

    @Override
    public void execute()  {
        ArrayList<IssueDetail> issueDetails = new ArrayList<IssueDetail>();
        issuedHistory = new IssuedHistory();

        if (library.getIssuedHistories() == null){
            System.out.println("No book to Return");
        }
        else {
            issuedHistories = library.getIssuedHistories();
            issuedHistory = issuedHistories.get(0);

            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.println("Enter the Book Number You want to Return");
                int bookno = Integer.parseInt(input.readLine());
                System.out.println("Enter the Customer Name");
                String name = input.readLine();
                String output = issuedHistory.getCustomerName(bookno, issuedHistory.getIssuedStorageDetails());
                if (name.equals(output)) {
                    System.out.println("Thank you for Returning the Book");
                    Book book = library.getBook(bookno);
                    book.setAvailability(true);

                } else {
                    System.out.println("This is Not a Valid Book To Return");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BookNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void add(IssuedHistory issuedHistory) {
        issuedHistories.add(issuedHistory);
    }
}
