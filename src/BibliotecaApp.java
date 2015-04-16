import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dabluk on 14/04/15.
 */
public class BibliotecaApp {
    private ArrayList<Book> books;

    public BibliotecaApp(){

        books = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void welcomeMessage(){
        System.out.println("************************************************");
        System.out.println("*       Welcome    to   the     Biblioteca     *");
        System.out.println("*           *************************          *");
        System.out.println("*            Banglore Public Library           *");
        System.out.println("************************************************");
    }
    public void addBooks(){
        books.add(new Book(1, "JAVA", "Herbert Schildt", "TMH"));
        books.add(new Book(2, "J2EE", "Herbert Schildt", "SUN"));
        books.add(new Book(3, "C++", "James Stourstrup", "TMH"));
        books.add(new Book(4, "ORACLE", "Harish Gaur", "Oracle"));
    }
//    public void showBooks(){
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//        System.out.println("---------------Avilable Books------------------");
//        System.out.println("Book No.                Book Name");
//        System.out.println("_______                 _________");
//        for (int i = 0; i < books.size(); i++) {
//            System.out.println(books.get(i));
//        }
//
//    }
//    public void getBookDetail(){
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println("Enter the Book Number for getting Details");
//            int bookno = Integer.parseInt(input.readLine());
//            System.out.println("Book No.                Book Name");
//            for (int i = 0; i < books.size(); i++) {
//                if ( books.get(i).getBookNo() == bookno){
//                    System.out.println(books.get(i));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
