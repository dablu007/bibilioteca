package test.com.twu.biblioteca;

import com.twu.biblioteca.command.ReturnBookCommand;
import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.Library;
import org.junit.Test;

/**
 * Created by dabluk on 20/04/15.
 */
public class ReturnBookCommandTests {

    @Test
    public void Should_Not_Initialize_With_An_Empty_Array() {
        Library library  = new Library();
        library.addBooks(new Book(1001, "The Diary of a Young Girl", "Anne Frank", "OttoFrank"));

        library.checkout(1001, "Some User");



        ReturnBookCommand command = new ReturnBookCommand(library);
    }

}
