import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 14/04/15.
 */
public class Main {
    public static void main(String args[]){
        Library library = new Library();
        library.welcomeMessage(); //TODO:
        library.addBooks();


        while (true){
            System.out.println("---------------Avilable Choices------------------");
            System.out.println("1.ListBooksCommand");
            System.out.println("2.Search Book By Book Number");
            System.out.println("3.Quit");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your Choice");
            int choice;

            ListBooksCommand listbooks = new ListBooksCommand(library);
            GetBookDetail getbookdetail = new GetBookDetail(library);

            Menu options = new Menu();

            options.addCommand(1, listbooks);
            options.addCommand(2, getbookdetail);

//            options.addOptionforCommandToExecute();

        //    CommandToExecute option = new CommandToExecute();
            try {
                choice = Integer.parseInt(input.readLine());
                ICommand command = options.getCommand(choice);
                command.execute();
//                option.executeSelectedOption(command);

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
