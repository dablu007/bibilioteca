package com.twu.biblioteca.command;

import com.twu.biblioteca.controller.IRentableObject;
import com.twu.biblioteca.controller.Library;
import com.twu.biblioteca.controller.RentableType;
import com.twu.biblioteca.controller.User;
import com.twu.biblioteca.view.Display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dabluk on 24/04/15.
 */
public class CheckOut {

    public void checkoutEntity(User user, Library library,RentableType type) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Display.getEntityDetails();
        Display.getEntityNo();
        String entityNo = null;
        try {
            entityNo = (input.readLine());
            IRentableObject entity = library.getRentableObject(entityNo, type);

            if (entity == null) {
                Display.entityNotCheckedOut();
                return;

            }
            IRentableObject checkedoutEntity = library.checkout(entity, user.getUserName());
            if (checkedoutEntity != null) {
                Display.entityCheckedOut();
                return;
            }
            else {
                Display.entityNotCheckedOut();
                return;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
