package com.redmadrobot.marketplace.exception;

public class AuthenticationException extends Exception{
    public AuthenticationException() {
    }

    public AuthenticationException(String ex) {
        super(ex);
    }
}
