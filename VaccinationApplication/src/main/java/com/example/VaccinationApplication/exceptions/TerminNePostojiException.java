package com.example.VaccinationApplication.exceptions;

public class TerminNePostojiException  extends RuntimeException{
    private String message;

    public TerminNePostojiException(String message) {
        this.message = message;
    }

    public TerminNePostojiException() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
