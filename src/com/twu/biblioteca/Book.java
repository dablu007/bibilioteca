package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by dabluk on 14/04/15.
 */
public class Book {
    private int bookNo;
    private String bookName;
    private String bookAuthor;
    private String bookPublication;
    public Book(int bookNo,String bookName,String bookAuthor,String  bookPublication){
        this.bookName = bookName;
        this.bookNo = bookNo;
        this.bookAuthor = bookAuthor;
        this.bookPublication = bookPublication;
    }

    public  int getBookNo() {
        return bookNo;
    }

    @Override
    public String toString() {
        return bookNo + "                  "+
                "     " + bookName  ;
    }

    /**
     * Created by dabluk on 14/04/15.
     */
    public static class Library {
        private ArrayList<Book> books;

        public Library(){

            books = new ArrayList<Book>();
        }

        public ArrayList<Book> getBooks() {
            return books;
        }


        public void addBooks(){
            books.add(new Book(1, "JAVA", "Herbert Schildt", "TMH"));
            books.add(new Book(2, "J2EE", "Herbert Schildt", "SUN"));
            books.add(new Book(3, "C++", "James Stourstrup", "TMH"));
            books.add(new Book(4, "ORACLE", "Harish Gaur", "Oracle"));
        }


    }

    /**
     * Created by dabluk on 15/04/15.
     */
    public static class ListBooksCommand implements ICommand {
        private  ArrayList<Book> books;

        public ListBooksCommand(Library app) {
            books = new ArrayList<Book>();
            this.books = app.getBooks();
        }
        @Override
        public void execute() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("---------------Avilable Books------------------");
            System.out.println("com.twu.biblioteca.Book No.                com.twu.biblioteca.Book Name");
            System.out.println("_______                 _________");
            for (int i = 0; i < books.size(); i++) {
                System.out.println(books.get(i));
            }
        }
    }
}
