package com.mastery.java.task.exception;

public class ErrorResponse {

    private String httpMethod;
    private String url;
    private String employeeNotFoundException;

    public ErrorResponse(String httpMethod, String url, String exception) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.employeeNotFoundException = exception;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public String getEmployeeNotFoundException() {
        return employeeNotFoundException;
    }
}
