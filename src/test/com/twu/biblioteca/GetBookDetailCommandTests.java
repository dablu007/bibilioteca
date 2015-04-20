package test.com.twu.biblioteca;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.ICanPrint;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.command.GetBookDetailCommand;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

/**
 * Created by dabluk on 16/04/15.
 */
public class GetBookDetailCommandTests {

    private ArrayList<Book> books;
    private GetBookDetailCommand getBookDetailCommand;
    @Before
    public void setup(){
        Library library = new Library();
        Book book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        library.addBooks(book);
        book = new Book(2,"ORACLE","Burleson","ORACLE");
        library.addBooks(book);
        getBookDetailCommand = new GetBookDetailCommand(library);
    }

    @Test
    public void ShouldGetABookDetail(){
        ICanPrint outputWriterMock = mock(ICanPrint.class);
        getBookDetailCommand.getaBook(outputWriterMock, 1);
        Mockito.verify(outputWriterMock, times(1)).write(String.format("%d%27s", 2, "ORACLE"));
    }
}
