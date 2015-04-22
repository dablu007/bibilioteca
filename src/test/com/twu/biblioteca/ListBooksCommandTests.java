package test.com.twu.biblioteca;

import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.ICanPrint;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.command.ListBooksCommand;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

/**
 * Created by dabluk on 16/04/15.
 */
public class ListBooksCommandTests {
    private ListBooksCommand listBooksCommand;
    @Before
    public void setup(){
        Library library = new Library();
        Book book = new Book("B1", "JAVA", "Herbert Schildt", "TMH");
        library.add(book);
        listBooksCommand = new ListBooksCommand(library);
    }


    @Test
    public void ShouldPrintBooksAddedToLibrary(){
        ICanPrint outputWriterMock = mock(ICanPrint.class);
        listBooksCommand.printbook(outputWriterMock, 0);
        Mockito.verify(outputWriterMock,times(1)).write(String.format("%d%27s", 1, "JAVA"));


    }
}