package test.com.twu.biblioteca;

import com.twu.biblioteca.controller.Book;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dabluk on 16/04/15.
 */
public class BookTests {

    @Test
    public void ShouldAddaBook(){
        Book book = new Book(1, "JAVA", "Herbert Schildt", "TMH");
        assertEquals(1, book.getBookNo());
    }

    @Test
    public void ShouldBeEqualToAnotherBook(){
        Book book1 = new Book(1, "Java", "Some auther", "ISBN");
        Book book2 = new Book(1, "Java", "Some auther", "ISBN");
        assertEquals(book1.gethashcode(),book2.gethashcode());
    }




}
