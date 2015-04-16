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
public class GetBookDetailTests {
    private ArrayList<Book> books;
    @Test
    public void testbookDetail(){

        Library library = new Library();
        Book book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        library.addBooks(book);
        GetBookDetail getBookDetail = new GetBookDetail(library);
        books = getBookDetail.getBooks();
        book = books.get(2);
        assertEquals(3, book.getBookNo());
    }
}
