/**
 * Created by dabluk on 15/04/15.
 */
public class CommandToExecute {

    private static ICommand command;
    public void executeSelectedOption(ICommand cmd){

        cmd.execute();
        this.command = cmd;
    //    System.out.println(command);
    }

    public static ICommand getCommand() {
        return command;
    }
}
