package com.dhernandez.gimnasio.web.exceptions;

public class UniqueException extends RuntimeException{
    public UniqueException(String message) {
        super(message);
    }
}
