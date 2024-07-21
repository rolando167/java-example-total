package com.total.api.Exceptions;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorMessage {
    private int statusCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private List<ApiSubError> subErrors;

    public ErrorMessage(int statusCode, LocalDateTime timestamp, String message, String path,
            List<ApiSubError> subErrors) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

}
