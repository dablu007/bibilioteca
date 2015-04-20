package com.twu.biblioteca.command;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.ICommand;
import com.twu.biblioteca.IssuedHistory;
import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dabluk on 16/04/15.
 */
public class ExitCommand implements ICommand {
    @Override
    public void execute() {
        System.out.println("Have A Nice Day");
        System.exit(0);
    }
}
//
//    /**
//     * Created by dabluk on 17/04/15.
//     */
//    public static class CheckoutBookCommand implements ICommand{
//
//        private ArrayList<Book> books;
//        private Library library = new Library();
//        private int checkoutOutput;
//        private IssuedHistory issuedHistory = new IssuedHistory();
//
//        public CheckoutBookCommand(Library library) {
//            books = new ArrayList<Book>();
//            this.books = library.getBooks();
//
//        }
//
//
//        @Override
//        public void execute() {
//
//            for (int i = 0; i < books.size() ; i++) {
//                    library.addBooks(books.get(i));
//            }
//            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Enter the Book Number for Checkout");
//            try {
//                int bookno = Integer.parseInt(input.readLine());
//
//                Book book  = library.Checkout(1,"Dablu");
//                // TODO
//    //            if (checkoutOutput == 1){
//    //               // IssueDetail bookissueDetail = new IssueDetail();
//    //               // issuedHistory.addIssueDetail(bookissueDetail);
//    //            }
//    //            else{
//    //                Display.printBookNotAvilable();
//    //            }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            //checkoutOutput = library.BookAvilabilityForCheckout(1);
//
//
//        }
//
//        public int getCheckoutOutput() {
//            return checkoutOutput;
//        }
//    }
//
