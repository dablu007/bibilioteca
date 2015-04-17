package com.twu.biblioteca.command;

import com.twu.biblioteca.ICommand;

/**
 * Created by dabluk on 16/04/15.
 */
public class ExitCommand implements ICommand {
    @Override
    public void execute() {
        System.out.println("Have A Nice Day");
        System.exit(0);
    }
}
