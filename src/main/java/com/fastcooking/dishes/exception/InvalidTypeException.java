package com.fastcooking.dishes.exception;

public class InvalidTypeException extends RuntimeException{

    public InvalidTypeException(String message) {
        super(message);
    }

    public InvalidTypeException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
