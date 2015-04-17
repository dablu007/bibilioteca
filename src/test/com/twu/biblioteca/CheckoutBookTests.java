package test.com.twu.biblioteca;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.CheckoutBook;
import com.twu.biblioteca.Library;
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
        CheckoutBook checkoutBook = new CheckoutBook(library);
        checkoutBook.execute();
        assertEquals(1, checkoutBook.getCheckoutOutput());

    }

    @Test
    public void ShouldNotThrowExceptionIfBookIsNotAvilable(){
        CheckoutBook checkoutBook = new CheckoutBook(library);
        checkoutBook.execute();
        books = library.getBooks();
    //    System.out.println(books.get(0).isAvailability());
        assertEquals(1, checkoutBook.getCheckoutOutput());
    }
}

