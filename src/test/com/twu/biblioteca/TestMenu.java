package test.com.twu.biblioteca;

/**
 * Created by dabluk on 16/04/15.
 */
import com.twu.biblioteca.controller.ICommand;
import com.twu.biblioteca.controller.Menu;
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

public class TestMenu {
    @Test
    public void ShouldCreateMenu()  {
        ICommand sampleCommand = new SampleCommand();

        Menu menu = new Menu();

        menu.addCommand(1,sampleCommand);

        assertEquals(menu.getCommand(1), sampleCommand);


    }
}