package test.com.twu.biblioteca;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.command.CheckoutBookCommand;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 17/04/15.
 */
public class CheckoutBookTests {
    private ArrayList<Book> books;
    Library library;
    @Before
    public void setup(){
        Book book  = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        library = new Library();
        library.addBooks(book);

    }

    @Test
    public void ShouldCheckoutABookIfAvilable(){
        CheckoutBookCommand checkoutBook = new CheckoutBookCommand(library);
        checkoutBook.execute();
        assertEquals(1, checkoutBook.getCheckoutOutput());

    }

    @Test
    public void ShouldNotThrowExceptionIfBookIsNotAvilable(){
        CheckoutBookCommand checkoutBook = new CheckoutBookCommand(library);
        checkoutBook.execute();
        books = library.getBooks();
        assertEquals(1, checkoutBook.getCheckoutOutput());
    }
}

