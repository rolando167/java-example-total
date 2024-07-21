package com.total.api.Exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorMessage {
    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String description;
    private List<ApiSubError> subErrors;

    public ErrorMessage(int statusCode, LocalDateTime timestamp, String message, String description,
            List<ApiSubError> subErrors) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
        this.subErrors = subErrors;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

}
