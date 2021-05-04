package com.mastery.java.task.dto;

public class ErrorResponse {

    private String httpMethod;
    private String url;

    public ErrorResponse(String httpMethod, String url) {
        this.httpMethod = httpMethod;
        this.url = url;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getUrl() {
        return url;
    }
}
