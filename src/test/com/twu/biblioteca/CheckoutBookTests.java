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
        Book book  = new Book("B1", "JAVA", "Herbert Schildt", "TMH");
        library = new Library();
        library.add(book);

    }
    @Test
    public void ShouldCheckoutAnBookObject(){
        Library library  = new Library();
        Book book = new Book("B1001", "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        library.add(book);

        Book checkedOutBook = (Book)library.checkoutObject(book, "Some User");

        assertEquals(book, checkedOutBook);

    }

}

