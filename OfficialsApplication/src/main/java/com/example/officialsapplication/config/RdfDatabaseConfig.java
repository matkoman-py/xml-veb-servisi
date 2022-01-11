package com.example.officialsapplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RdfDatabaseConfig {

    public RdfDatabaseConfig(String endpoint, String dataset, String query, String update, String data) {
        this.endpoint = endpoint;
        this.dataset = dataset;
        this.query = query;
        this.update = update;
        this.data = data;
    }

    public RdfDatabaseConfig() {
    }

    @Value("${conn.endpoint}")
    private String endpoint;

    @Value("${conn.dataset}")
    private String dataset;

    @Value("${conn.query}")
    private String query;

    @Value("${conn.update}")
    private String update;

    @Value("${conn.data}")
    private String data;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
