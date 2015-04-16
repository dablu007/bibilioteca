import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 14/04/15.
 */
public class Main {
    public static void main(String args[]){
        BibliotecaApp library = new BibliotecaApp();
        library.welcomeMessage();
        library.addBooks();


        while (true){
            System.out.println("---------------Avilable Choices------------------");
            System.out.println("1.ListBooksCommand");
            System.out.println("2.Search Book By Book Number");
            System.out.println("3.Quit");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your Choice");
            int choice;
    //        ICommand listbooks = new ListBooksCommand(library);
    //        ICommand getbookdetail = new GetBookDetail(library);



            OptionsAvilableForCommandToExecute optionsAvilableForCommandToExecute = new OptionsAvilableForCommandToExecute();
            optionsAvilableForCommandToExecute.addOptionforCommandToExecute();

            CommandToExecute option = new CommandToExecute();
            try {
                choice = Integer.parseInt(input.readLine());
                ICommand command = optionsAvilableForCommandToExecute.getValueofOptionforCommandToExecute(choice);
                command.setBooks(library);
                option.executeSelectedOption(command);

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
