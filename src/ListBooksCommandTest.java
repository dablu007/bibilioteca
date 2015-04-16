import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 16/04/15.
 */
public class ListBooksCommandTest {
    @Test
    public void checkListBooks(){
        Library library = new Library();
        library.addBooks();
        ListBooksCommand listBooksCommand = new ListBooksCommand(library);
        listBooksCommand.execute();
        assertEquals(4,listBooksCommand.getTotalbooks());
    }
}
