package com.example.VaccinationApplication.exceptions;

public class SaglasnostNijeIskazanaException  extends RuntimeException{
    private String message;

    public SaglasnostNijeIskazanaException(String message) {
        this.message = message;
    }

    public SaglasnostNijeIskazanaException() {
        super();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
