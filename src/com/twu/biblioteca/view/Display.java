package com.twu.biblioteca.view;

/**
 * Created by dabluk on 16/04/15.
 */

public class Display {
        public static void welcomeMessage(){
            System.out.println("************************************************");
            System.out.println("*       Welcome    to   the     Biblioteca     *");
            System.out.println("*           *************************          *");
            System.out.println("*            Banglore Public Library           *");
            System.out.println("************************************************");
        }
        public static void printMenu(){
            System.out.println("---------------Avilable Choices------------------");
            System.out.println("1.ListBooks");
            System.out.println("2.Search Book By Book Number");
            System.out.println("3.Book CheckOut");
            System.out.println("4.Return Book");
            System.out.println("5.Exit");
        }

        public static void printBookNotAvilable(){
            System.out.println("Sorry Book Number Entered is Not Avilable");
        }
}

