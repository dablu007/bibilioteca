package test.com.twu.biblioteca;

import com.twu.biblioteca.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 16/04/15.
 */
public class BookTests {
    @Test
    public void ShouldAddaBook(){
        Book book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        assertEquals(1,book.getBookNo());
    }
    @Test
    public void ShouldNotThrowExceptionWhenNoBookIsAdded(){
        Book book = new Book();
        assertEquals(0, book.getBookNo());
    }
}
