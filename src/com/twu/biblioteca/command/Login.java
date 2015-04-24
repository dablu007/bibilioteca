package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.User;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 24/04/15.
 */
public class Login {
    private String userId;
    private String password;

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
    public void enterDetails(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            Display.printTogetUserID();
            this.userId = input.readLine();
            Display.printTogetPassword();
            this.password = input.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
