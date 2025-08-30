package com.javarush.esin.exceptions;

public class AppException extends RuntimeException {

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

}
