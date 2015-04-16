import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dabluk on 15/04/15.
 */
public class GetBookDetail implements  ICommand{
    private ArrayList<Book> books;

    public GetBookDetail(BibliotecaApp app) {
        books = new ArrayList<Book>();
        this.books = app.getBooks();
    }

    public GetBookDetail() {

    }

    @Override
    public void execute() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the Book Number for getting Details");
            int bookno = Integer.parseInt(input.readLine());
            System.out.println("Book No.                Book Name");
            for (int i = 0; i < books.size(); i++) {
                if ( books.get(i).getBookNo() == bookno){
                    System.out.println(books.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBooks(BibliotecaApp library) {
        books = new ArrayList<Book>();
        //    BibliotecaApp library = (BibliotecaApp)cmd;
        this.books = library.getBooks();
    }

}
