package com.sri.movie_app.config.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(){
        super("USER NOT FOUND");
    }
}