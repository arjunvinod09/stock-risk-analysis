package com.project.user.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(String s) {
        super(s);
    }
}
