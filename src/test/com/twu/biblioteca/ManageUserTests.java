package test.com.twu.biblioteca;

import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.controller.ManageUser;
import com.twu.biblioteca.controller.User;
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
    private static User emptyUser = null;

    @Before
    public void setup(){
        manageUser = new ManageUser();
    }
    @Test
    public void ShouldAddAUser(){
        User user = new User("LIB-1001","Dablu","dablu@gmail.com","7679406898","dablu123");
        manageUser.add(user);
        assertEquals(1,manageUser.getUsers().size());
    }

    @Test
    public void ShouldCheckForAValidUser(){
        User user1 = new User("LIB-1001","Dablu","dablu@gmail.com","7679406898","dablu123");
        User user2 = new User("LIB-1002","Dablu 2","dablu2@gmail.com","7679403898","dablu098");

        manageUser.add(user1);
        manageUser.add(user2);

        assertTrue(manageUser.isValidUser("LIB-1002", "dablu098"));
    }

    @Test
    public void ShouldCheckForAInvalidValidUser(){
        User user = new User("LIB-1001","Dablu","dablu@gmail.com","7679406898","dablu123");
        manageUser.add(user);

        assertFalse(manageUser.isValidUser("LIB-1001", "dablu123"));
    }

}
