package com.nust.lms.exception;

import java.time.Instant;

/**
 * Simple JSON error response:
 * {
 *   "timestamp": "...",
 *   "status": 400,
 *   "error": "Bad Request",
 *   "message": "A book with this ID already exists.",
 *   "path": "/books"
 * }
 */
public class ApiErrorResponse {
    private Instant timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ApiErrorResponse() {}

    public ApiErrorResponse(Instant timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
