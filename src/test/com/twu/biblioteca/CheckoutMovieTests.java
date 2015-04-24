package test.com.twu.biblioteca;

import com.twu.biblioteca.command.CheckoutMovieCommand;
import com.twu.biblioteca.command.Login;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.controller.Movie;
import com.twu.biblioteca.controller.User;
import com.twu.biblioteca.controller.UserManager;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dabluk on 24/04/15.
 */
public class CheckoutMovieTests {
    private String expectedPattern;
    private SimpleDateFormat dateFormat;
    private Date inputDate;
    private Movie movie;
    private Library library;
    private CheckoutMovieCommand checkoutMovieCommand;
    private UserManager userManager = new UserManager();
    @Test
    public void ShouldCheckForaValidUser() throws ParseException {
        library = new Library();
        expectedPattern = "mm/dd/yyyy";
        dateFormat = new SimpleDateFormat(expectedPattern);
        String date = "14/07/2008";

        inputDate =  dateFormat.parse(date);
        movie = new Movie("Mov1","The Dark Night",inputDate,8,"Christopher Nolan");
        library.add(movie);
        User user = new User("LIB-1001","Dablu","dablu@gmail.com","7679406898","dablu123");
        userManager.add(user);
        checkoutMovieCommand = new CheckoutMovieCommand(library,userManager);
    //    checkoutMovieCommand.execute();

    }
}
