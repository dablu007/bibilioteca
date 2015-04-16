package com.twu.biblioteca;

import com.twu.biblioteca.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by dabluk on 15/04/15.
 */
public class GetBookDetail implements ICommand {
    private ArrayList<Book> books;
    public GetBookDetail(Library app) {
        books = new ArrayList<Book>();
        this.books = app.getBooks();
    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public void execute() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Book Number for getting Details");
            int bookno = Integer.parseInt(input.readLine());
            System.out.println("Book No.                Book Name");
            for (int i = 0; i < books.size(); i++) {
                if ( books.get(i).getBookNo() == bookno){
                    System.out.println(books.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
