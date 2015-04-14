/**
 * Created by dabluk on 14/04/15.
 */
public class Book {
    private int bookNo;
    private String bookName;
    public Book(int bookNo,String bookName){
        this.bookName = bookName;
        this.bookNo = bookNo;
    }

    @Override
    public String toString() {
        return bookNo + "                  "+
                "     " + bookName + '\'' ;
    }
}
