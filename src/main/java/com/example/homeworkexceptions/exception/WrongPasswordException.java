package com.example.homeworkexceptions.exception;

public class WrongPasswordException extends  RuntimeException {
    public WrongPasswordException(String message) {
        super(message);
    }
}
