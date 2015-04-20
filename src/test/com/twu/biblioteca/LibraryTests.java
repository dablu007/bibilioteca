package test.com.twu.biblioteca;
import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.exception.BookNotFoundException;
import com.twu.biblioteca.controller.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 16/04/15.
 */
public class LibraryTests {

    Library library;
    Book book;

    @Before
    public void Setup(){
        library = new Library();
        book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        library.addBooks(book);

    }

    @Test
    public void ShouldBeAbleToGetABookFromTheLibrary(){
        ArrayList<Book> books = library.getBooks();
        book = books.get(0);
        assertEquals(1, book.getBookNo());
    }

    @Test(expected = BookNotFoundException.class)
    public void ShouldThrowExceptionWhenBookIsNotThereInLibrary() throws BookNotFoundException {
        book = library.getBook(100);
    }

    @Test
    public void ShouldNotThrowExceptionWhenBookIsThereInLibrary() throws BookNotFoundException {
        book = library.getBook(1);
        assertNotNull(book);
        assertEquals(1, book.getBookNo());
    }
    @Test
    public void ShouldAddaBook() throws BookNotFoundException {
        book = library.getBook(1);
        assertEquals(1, book.getBookNo());
    }
    @Test
    public void ShouldCheckoutAIfBookNoCorrect(){
        book = library.Checkout(1, "Dablu");
        assertEquals(1, book.getBookNo());
    }
    @Test
    public void ShouldNotThrowExceptionWhenBookNotAvilable(){
        book = library.Checkout(5,"Dablu");
        assertNull(book);
    }
    @Test
    public void ShouldAssignABookIfAvilable(){
        book = library.Checkout(1,"Dablu");
        assertEquals(1, book.getBookNo());
    }
    @Test
    public void ShouldReturnNullWhenBookNoIsIvalid(){
        book = library.Checkout(10,"Dablu");
        assertNull(book);
    }
    @Test
    public void ShouldNotThrowExceptionWhenBookIsIssued() throws BookNotFoundException{
        book = library.Checkout(1,"Dablu");
        assertEquals(1,book.getBookNo());
        book = library.Checkout(1,"Dablu");

        assertNull(book);


    }
}
