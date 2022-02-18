package com.example.officialsapplication.dto;

import java.util.HashMap;

public class MetadataDTO {
    private String subject;
    private HashMap<String, String> values = new HashMap<>();

    public MetadataDTO(String subject, HashMap<String, String> values) {
        this.subject = subject;
        this.values = values;
    }

    public MetadataDTO() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public HashMap<String, String> getValues() {
        return values;
    }

    public void setValues(HashMap<String, String> values) {
        this.values = values;
    }
}
