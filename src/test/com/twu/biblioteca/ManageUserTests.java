package test.com.twu.biblioteca;

import com.twu.biblioteca.controller.UserManager;
import com.twu.biblioteca.controller.User;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dabluk on 23/04/15.
 */
public class ManageUserTests {

    private UserManager userManager;
    private User user;
    @Before
    public void setup(){
        userManager = new UserManager();
        user = new User("LIB-1001","Dablu","dablu@gmail.com","7679406898","dablu123");
        userManager.add(user);
    }


    @Test
    public void ShouldCheckForAValidUser(){
        User user1 = new User("LIB-1001","Dablu","dablu@gmail.com","7679406898","dablu123");
        User user2 = new User("LIB-1002","Dablu 2","dablu2@gmail.com","7679403898","dablu098");

        userManager.add(user1);
        userManager.add(user2);

        assertEquals(user1, userManager.isValidUser("LIB-1002", "dablu098"));
    }

    @Test
    public void ShouldCheckForAInvalidValidUser(){
        User user = new User("LIB-1001","Dablu","dablu@gmail.com","7679406898","dablu123");
        userManager.add(user);

        assertEquals(user, userManager.isValidUser("LIB-1001", "dablu123"));
    }
    @Test
    public void shouldCheckforAUserLoggedInOrNot(){
        User user = userManager.isValidUser("LIB-1001","dablu123");
        assertTrue(userManager.isLoggedIn());
    }
    @Test
    public void ShouldPrintUserDetailsWhichIsLoggedIn(){
        User user1 = userManager.isValidUser("LIB-1001","dablu123");
        assertEquals(user, user1);
    }
}
