package test.com.twu.biblioteca;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.CheckoutBook;
import com.twu.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        CheckoutBook checkoutBook = new CheckoutBook(library);

    }
}

