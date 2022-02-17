package com.example.VaccinationApplication.exceptions;

public class InteresovanjeAlreadyExistsException extends RuntimeException{
    private String message;

    public InteresovanjeAlreadyExistsException(String message) {
        this.message = message;
    }

    public InteresovanjeAlreadyExistsException() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
