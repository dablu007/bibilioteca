package test.com.twu.biblioteca;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.GetBookDetail;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.ListBooksCommand;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 16/04/15.
 */
public class TestGetBookDetail {
    private ArrayList<Book> books;
    @Test
    public void testbookDetail(){

        Library library = new Library();
        library.addBooks();
        GetBookDetail getBookDetail = new GetBookDetail(library);
        books = getBookDetail.getBooks();
        Book book = books.get(2);
        assertEquals(3, book.getBookNo());
    }
}
