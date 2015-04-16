package com.twu.biblioteca;

import java.util.HashMap;
/**
 * Created by dabluk on 15/04/15.
 */
public class Menu {
    private HashMap<Integer, ICommand> options;
    public Menu(){
        options = new HashMap<Integer, ICommand>();
    }

    public ICommand getCommand(int key){
        return options.get(key);
    }

    public void addCommand(int choiceNumber, ICommand command) {
        options.put(choiceNumber, command);
    }
}
