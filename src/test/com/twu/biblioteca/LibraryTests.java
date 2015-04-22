package test.com.twu.biblioteca;
import com.twu.biblioteca.controller.*;
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
        inputDate =  dateFormat.parse(date);
        movie = new Movie("Mov1","The Dark Night",inputDate,8,"Christopher Nolan");
        library.add(movie);

    }
//    /* Diffrent Test Cases for Listing  and Getting Books from the library */
//    @Test
//    public void ShouldBeAbleToGetABookFromTheLibrary(){
//        ArrayList<Book> books = library.getBooks();
//        assertEquals(1, books.size());
//        assertEquals(book, books.get(0));
//        books.clear();
//        assertEquals(1, library.getBooks().size());
//    }
//
//    @Test(expected = BookNotFoundException.class)
//    public void ShouldThrowExceptionWhenBookIsNotThereInLibrary() throws BookNotFoundException {
//        book = library.getBook(100);
//    }
//
//    @Test
//    public void ShouldNotThrowExceptionWhenBookIsThereInLibrary() throws BookNotFoundException {
//        book = library.getBook(1);
//        assertNotNull(book);
//        assertEquals(1, book.getBookNo());
//    }
//    @Test
//    public void ShouldAddaBook() throws BookNotFoundException {
//        book = library.getBook(1);
//        assertEquals(1, book.getBookNo());
//    }

    @Test
    public void ShouldAddBook(){
        library = new Library();
        book = new Book("B1", "JAVA", "Herbert Schildt", "TMH");
        library.add(book);
        assertEquals(1, library.getEntityList(RentableType.BOOK).size());
    }

    @Test
    public void ShouldAddMovie(){
        library.add(movie);
        assertEquals(1, library.getEntityList(RentableType.MOVIE).size());
    }
    @Test
    public void ShouldCheckForAAddedMovie(){
        expectedPattern = "mm/dd/yyyy";
        dateFormat = new SimpleDateFormat(expectedPattern);
        String date = "14/07/2008";
        try {
            inputDate =  dateFormat.parse(date);
            movie = new Movie("Mov1","The Dark Night",inputDate,8,"Christopher Nolan");
            library.add(movie);
            assertEquals(movie,library.getEntityList(RentableType.MOVIE).get(1));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /* Diffrent Test Cases for Checkout from the library */



    @Test
    public void ShouldAddAUser(){
        UserDetail user = new UserDetail("Dablu","dablu@gmail.com","7679406898");
        library.addUser(user);
        assertEquals(1, library.getUserDetails().size());
    }

    @Test
    public void ShouldGiveTheDetailsOfAUser(){

    }


    @Test
    public void ShouldCheckoutAnBookObject(){
        Library library  = new Library();
        Book book = new Book("B1001", "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        library.add(book);
        Book checkedOutBook = (Book)library.checkoutEntity(book, "Some User");

        assertEquals(book, checkedOutBook);

    }
    @Test
    public void ShouldCheckoutAnMovieObject(){
        Movie checoutmovie = (Movie)library.checkoutEntity(movie, "Dablu");
        assertEquals(movie, checoutmovie);
    }
    @Test
    public void ShouldGetACustomerNameAgainstABook(){
        Library library  = new Library();
        Book book = new Book("B1001", "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        library.add(book);
        Book checkedOutBook = (Book)library.checkoutEntity(book, "Dablu");

        IssueDetail issueDetail = library.getIssueDetail(book);
        assertEquals("Dablu", issueDetail.getCustomerName());


    }
    @Test
    public void ShouldGetACustomerNameAgainstAnMovie() throws ParseException {

        expectedPattern = "mm/dd/yyyy";
        dateFormat = new SimpleDateFormat(expectedPattern);
        String date = "14/07/2008";

            inputDate =  dateFormat.parse(date);
            movie = new Movie("Mov1","The Dark Night",inputDate,8,"Christopher Nolan");
            library.add(movie);

            Movie checkoutmovie = (Movie)library.checkoutEntity(movie, "dablu");
            IssueDetail issueDetail = library.getIssueDetail(movie);
            assertEquals("dablu", issueDetail.getCustomerName());



    }
    @Test
    public void ShouldReturnAnBookIssued(){
        Library library  = new Library();
        Book book = new Book("B1001", "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        library.add(book);
        Book checkedOutBook = (Book)library.checkoutEntity(book, "Dablu");
        assertTrue(library.returnRentableObject(book, "Dablu"));
    }

    @Test
    public void ShouldCheckForABookNoInLibraryAndGiveTheSameBook(){
        Library library = new Library();
        Book book = new Book("B1001", "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        library.add(book);
        assertEquals(book, library.isObjectNull("B1001",RentableType.BOOK));
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
        Library library  = new Library();
        Book book = new Book("B1001", "The Diary of a Young Girl", "Anne Frank", "OttoFrank");
        library.add(book);
        book = new Book("B1", "JAVA", "Herbert Schildt", "TMH");
        library.add(book);
        book = new Book("B2", "C", "Dennis Richie", "Sun");
        library.add(book);
        book = new Book("B3", "ORACLE", "Harish Gaur", "TMH");
        library.add(book);
        book = new Book("B4", "C++", "Herbert Schildt", "TMH");
        library.add(book);

        ArrayList<IRentableObject> books = library.getEntityList(RentableType.BOOK);
        assertEquals(book.gethashcode(), books.get(4).gethashcode());

    }
    @Test
    public void ShouldShowAlistOfMovies() throws ParseException {
        expectedPattern = "mm/dd/yyyy";
        dateFormat = new SimpleDateFormat(expectedPattern);
        String date = "14/07/2008";
        inputDate =  dateFormat.parse(date);
        movie = new Movie("Mov1","The Dark Night",inputDate,8,"Christopher Nolan");
        library.add(movie);

        movie = new Movie("Mov2","Fast and Furious 7",inputDate,7,"James Wan");
        library.add(movie);
        movie = new Movie("Mov3","The Dark Knight Rises",inputDate,9,"Christopher Nolan");
        library.add(movie);
        ArrayList<IRentableObject> movies = library.getEntityList(RentableType.MOVIE);
        System.out.println(movie);
        assertEquals(movie.gethashcode(), movies.get(3).gethashcode());

    }

}
