package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.User;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 24/04/15.
 */
public class PrintUserDetails {
    public void printDetails(User user){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Display.printUserOption();
        try {
            String option = input.readLine();
            if (option.equals("N")){
                return;
            }

            System.out.println(user);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
