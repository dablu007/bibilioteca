package test.com.twu.biblioteca;
import com.twu.biblioteca.controller.*;
import org.junit.Before;
import org.junit.Test;

import javax.management.MalformedObjectNameException;
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
    public  void Setup() throws ParseException {
        library = new Library();
        book = new Book("B1", "JAVA", "Herbert Schildt", "TMH");
        library.add(book);
        expectedPattern = "mm/dd/yyyy";
        dateFormat = new SimpleDateFormat(expectedPattern);
        String date = "14/07/2008";
        inputDate = dateFormat.parse(date);
        movie = new Movie("Mov1", "The Dark Night", inputDate, 8, "Christopher Nolan");
        library.add(movie);
    }

    @Test
    public void ShouldCheckForAAddedMovie(){
        assertEquals(movie,library.getEntityList(RentableType.MOVIE).get(0));
    }
    /* Diffrent Test Cases for Checkout from the library */


    @Test
    public void ShouldCheckoutAnBook(){
        User user = new User("1001", "Username", "as@asd.com", "131313", "password");
        user.IsLoggedIn = false;

        library.checkoutEntity(book, user);


        Book checkedOutBook = (Book)library.checkoutEntity(book, "Some User");
        assertEquals(book, checkedOutBook);

    }
    @Test
    public void ShouldCheckoutAnMovie(){
        Movie checoutmovie = (Movie)library.checkoutEntity(movie, "Dablu");
        assertEquals(movie, checoutmovie);
    }
    @Test
    public void ShouldGetACustomerNameAgainstABook(){
        Book checkedOutBook = (Book)library.checkoutEntity(book, "Dablu");
        IssueDetail issueDetail = library.getIssueDetail(book);
        assertEquals("Dablu", issueDetail.getCustomerName());


    }
    @Test
    public void ShouldGetACustomerNameAgainstAnMovie() throws ParseException {
            Movie checkoutmovie = (Movie)library.checkoutEntity(movie, "dablu");
            IssueDetail issueDetail = library.getIssueDetail(movie);
            assertEquals("dablu", issueDetail.getCustomerName());
    }

    @Test
    public void ShouldReturnAnBookIssued(){
        Book checkedOutBook = (Book)library.checkoutEntity(book, "Dablu");
        assertTrue(library.returnRentableObject(book, "Dablu"));
    }

    @Test
    public void ShouldCheckForABookNoInLibraryAndGiveTheSameBook(){
        assertEquals(book, library.getRentableObject("B1", RentableType.BOOK));
    }


    @Test
    public void ShouldReturnNullWhenAnObjectIsAlreadyCheckedOut(){
        Library library  = new Library();
        Book book = new Book("B1001", "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        library.add(book);
        Book checkedOutBook = (Book)library.checkoutEntity(book, "Dablu");
        Book checkedOutBook1 = (Book)library.checkoutEntity(book, "Dablu");
        assertNull(checkedOutBook1);
    }
    @Test
    public void ShouldNotThrowExceptionWhenNoIssueIsPresent(){
        Library library  = new Library();
        Book book = new Book("B1001", "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        library.add(book);
        assertNull(library.getIssueDetail(book));
    }
    @Test
    public void ShouldShowAListofBooks(){
        book = new Book("B1001", "JAVA", "Herbert Schildt", "TMH");
        library.add(book);
        book = new Book("B2", "C", "Dennis Richie", "Sun");
        library.add(book);
        book = new Book("B3", "ORACLE", "Harish Gaur", "TMH");
        library.add(book);
        book = new Book("B4", "C++", "Herbert Schildt", "TMH");
        library.add(book);

        ArrayList<IRentableObject> books = library.getEntityList(RentableType.BOOK);
        assertEquals(book, books.get(4));

    }
    @Test
    public void ShouldShowAlistOfMovies() throws ParseException {
        //TODO
        movie = new Movie("Mov2","Fast and Furious 7",inputDate,7,"James Wan");
        library.add(movie);
        movie = new Movie("Mov3","The Dark Knight Rises",inputDate,9,"Christopher Nolan");
        library.add(movie);
        ArrayList<IRentableObject> movies = library.getEntityList(RentableType.MOVIE);
        assertEquals(movie, movies.get(2));
    }






}
