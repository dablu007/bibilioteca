package test.com.twu.biblioteca;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.ListBooksCommand;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 16/04/15.
 */
public class ListBooksCommandTests {

    private ArrayList<Book> books;
    @Test
    public void testBooksList(){

        Library library = new Library();
        Book book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        library.addBooks(book);

        ListBooksCommand listBooksCommand = new ListBooksCommand(library);
//        books = listBooksCommand.getBooks();
//        Book book = books.get(1);
//        assertEquals(2, book.getBookNo());
    }
}