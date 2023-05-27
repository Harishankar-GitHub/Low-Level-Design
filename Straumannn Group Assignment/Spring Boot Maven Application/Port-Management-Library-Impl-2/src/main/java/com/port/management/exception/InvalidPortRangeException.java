package com.port.management.exception;

public class InvalidPortRangeException extends RuntimeException {

    public InvalidPortRangeException() {
        super("Invalid port range");
    }
}
