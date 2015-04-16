package com.twu.biblioteca;

/**
 * Created by dabluk on 16/04/15.
 */
public class Exit implements ICommand {
    @Override
    public void execute() {
        System.out.println("Have A Nice Day");
        System.exit(0);
    }
}
