import java.util.HashMap;

/**
 * Created by dabluk on 15/04/15.
 */
public class OptionsAvilableForCommandToExecute {
    private HashMap<Integer, ICommand> setOfOptionsforCommandtoExecute;
    private String valueofOption;
    private ICommand cmdforListbooks, cmdforGetbookDetail;
    public OptionsAvilableForCommandToExecute(){
        setOfOptionsforCommandtoExecute = new HashMap<Integer, ICommand>();
        cmdforListbooks = new ListBooksCommand();
        cmdforGetbookDetail = new GetBookDetail();

    }

    public void addOptionforCommandToExecute(){
        setOfOptionsforCommandtoExecute.put(1, cmdforListbooks);
        setOfOptionsforCommandtoExecute.put(2, cmdforGetbookDetail);

    }


    public ICommand getValueofOptionforCommandToExecute(int key) {
        ICommand cmdtoExecute = setOfOptionsforCommandtoExecute.get(key);
        return cmdtoExecute;
    }

}
