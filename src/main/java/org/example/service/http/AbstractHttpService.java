package org.example.service.http;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;

public abstract class AbstractHttpService {
    protected final HttpClient httpClient;
    protected final ObjectMapper om;

    protected AbstractHttpService(HttpClient httpClient, ObjectMapper om) {
        this.httpClient = httpClient;
        this.om = om;
    }
}
