package com.sri.movie_app.config.exceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException(){
        super("INVALID PASSWORD");
    }
}