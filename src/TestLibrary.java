import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 16/04/15.
 */
public class TestLibrary {
    private ArrayList<Book> books;
    Library library;
    Book book;
    @Test
    public void testLibrary(){
        library = new Library();
        library.addBooks();
        books = library.getBooks();
        book = books.get(0);
        assertEquals(1,book.getBookNo());
    }
}
