import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 15/04/15.
 */
public class CommandToExecuteTests {

    CommandToExecute commandToExecute;
    @Before
    public void setup(){
        ICommand command = mock(ICommand.class);
    }



    @Test
    public void ShouldBeAbleToGetACommandToExecuteOption(){
        ListBooksCommand listbooks = new ListBooksCommand();
        ICommand cmd = CommandToExecute.getCommand();
    //    System.out.println(listbooks);
        System.out.println(cmd);
        assertEquals(listbooks, cmd);
    }

}
