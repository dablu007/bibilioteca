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
        public static void printToGetBook(){
            System.out.println("Enter the Book Details");
        }
        public static void printToGetCustomerName(){
            System.out.println("Enter the Customer Name");
        }
        public static void printBookReturned(){
            System.out.println("Thank you For Returning the Book");
        }
        public static void printBookNotReturned(){
            System.out.println("This is Not a Valid Book to Return");
        }

        public static void printBookCheckedOut(){
            System.out.println("Thank you! Enjoy the book");
        }
        public static void printBookNotCheckedOut(){
            System.out.println("That Book is Not Avilable");
        }

        public static void printExit() {
            System.out.println("Have A Nice Day..");
        }

        public static void printToGetBookNo() {
            System.out.println("Enter the Book No.");
        }

        public static void printToGetBookName() {
            System.out.println("Enter the Book Name");
        }

        public static void printToGetBookAuthor() {
            System.out.println("Enter the Book Author");
        }

        public static void printToGetBookPublication() {
            System.out.println("Enter the Book Publication");
        }
}

