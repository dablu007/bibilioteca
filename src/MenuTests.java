import com.twu.biblioteca.ICommand;
import com.twu.biblioteca.Menu;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 16/04/15.
 */


class SampleCommand implements ICommand {

    @Override
    public void execute() {

    }
}

public class MenuTests {

    @Test
    public void ShouldCreateMenu()  {
        ICommand sampleCommand = new SampleCommand();

        Menu menu = new Menu();
        menu.addCommand(1,sampleCommand);
        menu.addCommand(2,null);

        assertEquals(menu.getCommand(1), sampleCommand);


    }
}
