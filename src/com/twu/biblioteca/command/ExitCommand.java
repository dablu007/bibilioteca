package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.ICommand;
import com.twu.biblioteca.view.Display;

/**
 * Created by dabluk on 16/04/15.
 */
public class ExitCommand implements ICommand {
    @Override
    public void execute() {
        Display.exit();
        System.exit(0);
    }
}
