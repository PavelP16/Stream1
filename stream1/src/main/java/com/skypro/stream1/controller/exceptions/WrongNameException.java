package com.skypro.stream1.controller.exceptions;

public class WrongNameException extends RuntimeException{
    public WrongNameException(String message) {
        super(message);
    }
}