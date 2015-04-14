import java.util.ArrayList;

/**
 * Created by dabluk on 14/04/15.
 */
public class BibliotecaApp {
    private ArrayList<Book> books;

    public BibliotecaApp(){
        books = new ArrayList<Book>();
    }

    public void welcomeMessage(){
        System.out.println("************************************************");
        System.out.println("*       Welcome    to   the     Biblioteca     *");
        System.out.println("*           *************************          *");
        System.out.println("*            Banglore Public Library           *");
        System.out.println("************************************************");
    }
    public void addBooks(){
        books.add(new Book(1, "JAVA"));
        books.add(new Book(2, "J2EE"));
        books.add(new Book(1, "C++"));
        books.add(new Book(1, "ORACLE"));
    }
    public void showBooks(){
        System.out.println("---------------Avilable Book------------------");
        System.out.println("Book No.                Book Name");
        System.out.println("_______                 _________");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
}
