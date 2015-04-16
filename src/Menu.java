import java.util.HashMap;

/**
 * Created by dabluk on 15/04/15.
 */
public class Menu {
    private HashMap<Integer, ICommand> setOfOptionsforCommandtoExecute;

    public Menu(){
        setOfOptionsforCommandtoExecute = new HashMap<Integer, ICommand>();
    }

    public ICommand getCommand(int key) {
        return setOfOptionsforCommandtoExecute.get(key);
    }

    public void addCommand(int choiceNumber, ICommand command) {
        setOfOptionsforCommandtoExecute.put(choiceNumber, command);
    }
}
