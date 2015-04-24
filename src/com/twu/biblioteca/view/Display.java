package com.twu.biblioteca.view;

import com.twu.biblioteca.controller.RentableType;

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
            System.out.println("5.List Movies");
            System.out.println("6.Movie CheckOut");
            System.out.println("7.Exit");
        }

        public static void printBookNotAvilable(){
            System.out.println("Sorry Book Number Entered is Not Avilable");
        }
        public static void printToGetBook(){
            System.out.println("Enter the Book Details");
        }
        public static void getCustomerName(){
            System.out.println("Enter the Customer Name");
        }
        public static void bookReturned(){
            System.out.println("Thank you For Returning the Book");
        }
        public static void bookNotReturned(){
            System.out.println("This is Not a Valid Book to Return");
        }

        public static void bookCheckedOut(){
            System.out.println("Thank you! Enjoy the book");
        }
        public static void bookNotCheckedOut(){
            System.out.println("That Book is Not Avilable");
        }

        public static void exit() {
            System.out.println("Have A Nice Day..");
        }

        public static void getBookNo() {
            System.out.println("Enter the Book No.");
        }
        public static void printMovieList(){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("------------------------------Avilable Movies------------------------------");
            System.out.println(String.format("%s%17s%17s%17s%17s","Movie No.","MovieName","MovieRating","DirectorName","DateOfRelease"));
        }

        public static void printBooksList() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("------------------------------Avilable Books--------------------------");
            System.out.println(String.format("%s%17s%17s%27s","Book No.","BookName","Author","Publication"));
        }


    public static void getUserID() {
        System.out.println("Enter the User Library Number");
    }

    public static void getPassword() {
        System.out.println("Enter the Password");
    }

    public static void invalidPassword() {
        System.out.println("Invalid Credentials given please give the Correct One.");
    }

    public static void printBook() {
        System.out.println(String.format("%s%17s%17s%27s","Book No.","BookName","Author","Publication"));
    }

    public static void printUserOption() {
        System.out.println("Want to see Your Details Press Y to See N to Exit");
    }

    public static void enterLoginDetails() {
        System.out.println("Enter Your Details to Login");
        System.out.println();
    }

    public static void enterDetailsOfEntity(RentableType type) {
        if (type == RentableType.BOOK)
            System.out.println("Enter the Details of Book for Checkout");
        else
            System.out.println("Enter the Details of Movie for Checkout");

    }

    public static void EnterIdOfEntity(RentableType type) {
        if (type == RentableType.BOOK)
            System.out.println("Enter the Book Number");
        else
            System.out.println("Enter the Movie Number");
    }

    public static void cannotFindEntityMessage(RentableType type) {
        if (type == RentableType.BOOK)
            System.out.println("This Book is Not Avilable");
        else
            System.out.println("This Movie is Not Avilable");
    }

    public static void successfullyCheckedOutEntity(RentableType type) {
        if (type == RentableType.BOOK)
            System.out.println("Thank You! Enjoy Your Book");
        else
            System.out.println("Thank You! Enjoy Your Movie");
    }

    public static void successfullyReturnedEntity(RentableType type) {
        if (type == RentableType.BOOK)
            System.out.println("Thank You For Returning the Book");
        else
            System.out.println("Thank You for Returning the Movie");
    }

    public static void unsuccessfullEntityToReturn(RentableType type) {
        if (type == RentableType.BOOK)
            System.out.println("This is not a valid Book to Return");
        else
            System.out.println("This is not a valid Movie to Return");
    }
}

