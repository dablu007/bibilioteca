package test.com.twu.biblioteca;

import com.twu.biblioteca.controller.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by dabluk on 16/04/15.
 */
public class BookTests {
    @Test
    public void ShouldAddaBook(){
        Book book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        assertEquals(1, book.getBookNo());
    }





}
