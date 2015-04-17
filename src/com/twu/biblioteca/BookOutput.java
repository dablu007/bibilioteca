package com.twu.biblioteca;

/**
 * Created by dabluk on 17/04/15.
 */
public class BookOutput implements ICanPrint {
    @Override
    public void write(String printbook) {
        System.out.println(printbook);
    }
}
