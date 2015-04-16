/**
 * Created by dabluk on 14/04/15.
 */
public class Book {
    private int bookNo;
    private String bookName;
    private String bookAuthor;
    private String bookPublication;
    public Book(int bookNo,String bookName,String bookAuthor,String  bookPublication){
        this.bookName = bookName;
        this.bookNo = bookNo;
        this.bookAuthor = bookAuthor;
        this.bookPublication = bookPublication;
    }

    public  int getBookNo() {

        return bookNo;
    }

    @Override
    public String toString() {
        return bookNo + "                  "+
                "     " + bookName  ;
    }
}
