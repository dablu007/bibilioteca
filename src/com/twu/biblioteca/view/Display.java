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

    public static void movieCheckedOut() {
        System.out.println("Thank you! Enjoy the Movie");
    }

    public static void movieNotCheckedOut() {
        System.out.println("This Movie is Not Available");
    }

    public static void getMovie() {
        System.out.println("Enter the Movie Detail");
    }

    public static void getMovieNo() {
        System.out.println("Enter the Movie Number");
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
        System.out.println("Enter Details to Login");
    }

    public static void getEntityDetails() {
        System.out.println("Enter the Details for Rentable Entity You Want to Checkout");
    }

    public static void getEntityNo() {
        System.out.println("Enter the Rentable Entity Number");
    }

    public static void entityNotCheckedOut() {
        System.out.println("This Entity is Not Avilable");
    }

    public static void entityCheckedOut() {
        System.out.println("Thank You! Enjoy Your Stuff");
    }
}

