package test.com.twu.biblioteca;
import com.twu.biblioteca.command.CheckoutBookCommand;
import com.twu.biblioteca.controller.Book;
import com.twu.biblioteca.controller.IssuedHistory;
import com.twu.biblioteca.controller.Movie;
import com.twu.biblioteca.exception.BookNotFoundException;
import com.twu.biblioteca.controller.Library;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dabluk on 16/04/15.
 */
public class LibraryTests {

    Library library;
    Book book;
    String expectedPattern;
    SimpleDateFormat dateFormat;
    @Before
    public void Setup(){
        library = new Library();
        book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        library.addBooks(book);
        expectedPattern = "mm/dd/yyyy";
        dateFormat = new SimpleDateFormat(expectedPattern);
    }

    @Test
    public void ShouldBeAbleToGetABookFromTheLibrary(){
        ArrayList<Book> books = library.getBooks();

        assertEquals(1, books.size());
        assertEquals(book, books.get(0));

        books.clear();

        assertEquals(1, library.getBooks().size());
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
        book = library.checkout(1, "Dablu");
        assertEquals(1, book.getBookNo());
    }
    @Test
    public void ShouldNotThrowExceptionWhenBookNotAvilable(){
        book = library.checkout(5, "Dablu");
        assertNull(book);
    }
    @Test
    public void ShouldAssignABookIfAvilable(){
        book = library.checkout(1, "Dablu");
        assertEquals(1, book.getBookNo());
    }

    @Test
    public void ShouldBeAbleToCheckoutDetail(){
        Library library  = new Library();
        Book book = new Book(1001, "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        library.addBooks(book);

        Book checkedOutBook = library.checkout(1001, "Some User");

        assertEquals(book, checkedOutBook);
        assertEquals("Some User", library.getIssueDetail(checkedOutBook.getBookNo()));
    }

    @Test
    public void ShouldReturnNullWhenBookNoIsIvalid(){
        book = library.checkout(10, "Dablu");
        assertNull(book);
    }
    @Test
    public void ShouldNotThrowExceptionWhenBookIsIssued() throws BookNotFoundException{
        book = library.checkout(1, "Dablu");
        assertEquals(1,book.getBookNo());
        book = library.checkout(1, "Dablu");

        assertNull(book);


    }

    @Test
    public void ShouldReturnABookToLibrary(){
        Book book = new Book(1001, "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        Library library = new Library();
        library.addBooks(book);
        library.checkout(book.getBookNo(), "Dablu");
        boolean bookIsReturned = library.returnBook(book.getBookNo(),"Dablu");
        assertTrue(bookIsReturned);
    }

    @Test
    public void ShouldReturnFalseWhenReturnedBookIsNotInLibrary(){
        Book book = new Book(1001, "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        Library library = new Library();
        library.addBooks(book);
        library.checkout(5, "Dablu");
        boolean bookIsReturned = library.returnBook(book.getBookNo(),"Dablu");
        assertFalse(bookIsReturned);
    }

    @Test
    public void ShouldReturnFalseWhenReturnedBookUserNameIsWrong(){
        Book book = new Book(1001, "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        Library library = new Library();
        library.addBooks(book);
        library.checkout(1001, "Dablu");
        boolean bookIsReturned = library.returnBook(book.getBookNo(),"Dablu Kumar");
        assertFalse(bookIsReturned);
    }

    @Test
    public void ShouldAddAMovie(){
        String date = "14/07/2008";
        try {
            Date inputDate =  dateFormat.parse(date);
            Movie movie = new Movie("The Dark Night",inputDate,8,"Christopher Nolan");
            library.addMovie(movie);
            assertEquals(1, library.getMoviesList().size());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void ShouldReturnNullWhenNoMovieIsPresent(){
        assertNull(library.getMoviesList());
    }
    @Test
    public void ShouldNotThrowExceptionWhenThereIsNoMoiveAtDesiredIndex(){
        String date = "14/07/2008";
        try {
            Date inputDate =  dateFormat.parse(date);
            Movie movie = new Movie("The Dark Night",inputDate,8,"Christopher Nolan");
            library.addMovie(movie);
            assertEquals(movie, library.getMoviesList().get(0));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
