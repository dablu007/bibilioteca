import java.util.ArrayList;

/**
 * Created by dabluk on 15/04/15.
 */
public class ListBooksCommand implements ICommand {
    private  ArrayList<Book> books;

    public ListBooksCommand(BibliotecaApp app) {
        books = new ArrayList<Book>();
        this.books = app.getBooks();
    }

    public ListBooksCommand() {

    }


    @Override
    public void execute() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("---------------Avilable Books------------------");
        System.out.println("Book No.                Book Name");
        System.out.println("_______                 _________");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

    @Override
    public void setBooks(BibliotecaApp library) {
        books = new ArrayList<Book>();
    //    BibliotecaApp library = (BibliotecaApp)cmd;
        this.books = library.getBooks();
    }


}
