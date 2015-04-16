package com.twu.biblioteca;

/**
 * Created by dabluk on 16/04/15.
 */
public class Display {
    public void welcomeMessage(){
        System.out.println("************************************************");
        System.out.println("*       Welcome    to   the     Biblioteca     *");
        System.out.println("*           *************************          *");
        System.out.println("*            Banglore Public com.twu.biblioteca.Library           *");
        System.out.println("************************************************");
    }
    public void printMenu(){
        System.out.println("---------------Avilable Choices------------------");
        System.out.println("1.ListBooksCommand");
        System.out.println("2.Search Book By Book Number");
        System.out.println("3.Quit");
    }
}
