package test.com.twu.biblioteca;
import com.twu.biblioteca.controller.*;
import com.twu.biblioteca.exception.BookNotFoundException;
import com.twu.biblioteca.exception.MovieNotFound;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
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
    Date inputDate;
    Movie movie;
    @Before
    public  void Setup(){
        library = new Library();
        book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        library.addBooks(book);
        expectedPattern = "mm/dd/yyyy";
        dateFormat = new SimpleDateFormat(expectedPattern);
        String date = "14/07/2008";
        try {
            inputDate =  dateFormat.parse(date);
            movie = new Movie("The Dark Night",inputDate,8,"Christopher Nolan");
            library.addMovie(movie);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /* Diffrent Test Cases for Listing  and Getting Books from the library */
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
    public void ShouldAddBook(){
        library = new Library();
        book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        library.add(book);
        assertEquals(1, library.getObjectList().size());
    }

    @Test
    public void ShouldAddMovie(){
        library.add(movie);
        assertEquals(1, library.getObjectList().size());
    }
    @Test
    public void ShouldCheckForAAddedMovie(){
        expectedPattern = "mm/dd/yyyy";
        dateFormat = new SimpleDateFormat(expectedPattern);
        String date = "14/07/2008";
        try {
            inputDate =  dateFormat.parse(date);
            movie = new Movie("The Dark Night",inputDate,8,"Christopher Nolan");
            library.add(movie);
            assertEquals(movie,library.getObjectList().get(0));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /* Diffrent Test Cases for Checkout from the library */
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
        library.add(book);

        Book checkedOutBook = library.checkout(book, "Some User");

        assertEquals(book, checkedOutBook);
        assertEquals("Some User", library.getIssueDetail(checkedOutBook.getBookNo()).getCustomerName());
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

    /* Diffrent Test Cases for Returning Book to the library*/
    @Before
    public void AddDetailToLibrary(){
        book = new Book(1001, "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        library = new Library();
        library.addBooks(book);
    }


    @Test
    public void ShouldReturnABookToLibrary(){
        library.checkout(book.getBookNo(), "Dablu");
        boolean bookIsReturned = library.returnBook(book.getBookNo(),"Dablu");
        assertTrue(bookIsReturned);
    }

    @Test
    public void ShouldReturnFalseWhenReturnedBookIsNotInLibrary(){
        library.checkout(5, "Dablu");
        boolean bookIsReturned = library.returnBook(book.getBookNo(),"Dablu");
        assertFalse(bookIsReturned);
    }

    @Test
    public void ShouldReturnFalseWhenReturnedBookUserNameIsWrong(){
        library.checkout(1001, "Dablu");
        boolean bookIsReturned = library.returnBook(book.getBookNo(),"Dablu Kumar");
        assertFalse(bookIsReturned);
    }

    /* Diffrent  Test Cases for Adding a movie to library and Checkout of movie */
    @Test
    public void ShouldAddAMovie(){
            assertEquals(1, library.getMoviesList().size());
    }

    @Test
    public void ShouldReturnNullWhenNoMovieIsPresent(){
        assertNull(library.getMoviesList());
    }
    @Test
    public void ShouldNotThrowExceptionWhenThereIsNoMoiveAtDesiredIndex() throws MovieNotFound {
        if (library.getMoviesList().get(1) == null)
            throw new MovieNotFound("Movie Not Found");
        assertEquals(movie, library.getMoviesList().get(0));
    }

    @Test
    public void ShouldCheckoutAMovie() {
        assertEquals(movie, library.checkoutMovie("The Dark Night"));
    }


    @Test
    public void ShouldAddAUser(){
        UserDetail user = new UserDetail("Dablu","dablu@gmail.com","7679406898");
        library.addUser(user);
        assertEquals(1, library.getUserDetails().size());
    }

    @Test
    public void ShouldGiveTheDetailsOfAUser(){

    }

}
