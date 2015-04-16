package test.com.twu.biblioteca;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.BookNotFoundException;
import com.twu.biblioteca.Library;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static junit.framework.TestCase.assertNotNull;
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
        assertEquals(1,book.getBookNo());
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
}
