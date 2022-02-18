package com.example.VaccinationApplication.exceptions;

public class KorisnikPostojiException extends RuntimeException{
    private String message;

    public KorisnikPostojiException(String message) {
        this.message = message;
    }

    public KorisnikPostojiException() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
