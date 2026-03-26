package com.nust.lms.exception;

/**
 * Base runtime exception for API errors.
 * We'll convert these into clean JSON responses in a global exception handler.
 */
public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
