package com.twu.biblioteca.command;

/**
 * Created by dabluk on 23/04/15.
 */
public class LoginDetails {
    private String userId;
    private String userName;
    private String password;
    public LoginDetails(String userId,String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }
}
