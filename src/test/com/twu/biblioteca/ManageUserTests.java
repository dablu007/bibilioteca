package test.com.twu.biblioteca;

import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.controller.ManageUser;
import com.twu.biblioteca.controller.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dabluk on 23/04/15.
 */
public class ManageUserTests {

    private ManageUser manageUser;
    private User user;
    @Before
    public void setup(){
        manageUser = new ManageUser();
        user = new User("LIB-1001","Dablu","dablu@gmail.com","7679406898","dablu123");
        manageUser.add(user);
    }


    @Test
    public void ShouldCheckForAValidUser(){
        User user1 = new User("LIB-1001","Dablu","dablu@gmail.com","7679406898","dablu123");
        User user2 = new User("LIB-1002","Dablu 2","dablu2@gmail.com","7679403898","dablu098");

        manageUser.add(user1);
        manageUser.add(user2);

        assertEquals(user1, manageUser.isValidUser("LIB-1002", "dablu098"));
    }

    @Test
    public void ShouldCheckForAInvalidValidUser(){
        User user = new User("LIB-1001","Dablu","dablu@gmail.com","7679406898","dablu123");
        manageUser.add(user);

        assertEquals(user,manageUser.isValidUser("LIB-1001", "dablu123"));
    }
    @Test
    public void shouldCheckforAUserLoggedInOrNot(){
        User user = manageUser.isValidUser("LIB-1001","dablu123");
        assertTrue(manageUser.isLoggedIn());
    }
    @Test
    public void ShouldPrintUserDetailsWhichIsLoggedIn(){
        User user1 = manageUser.isValidUser("LIB-1001","dablu123");
        assertEquals(user,user1);
    }
}
