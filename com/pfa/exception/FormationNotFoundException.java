package com.pfa.exception;

public class FormationNotFoundException extends RuntimeException {

    public FormationNotFoundException() {
        super();
    }

    public FormationNotFoundException(String message) {
        super(message);
    }

    public FormationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
