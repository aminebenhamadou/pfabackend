package com.pfa.exception;

public class FormateurNotFoundException extends RuntimeException {

    public FormateurNotFoundException() {
        super();
    }

    public FormateurNotFoundException(String message) {
        super(message);
    }

    public FormateurNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
