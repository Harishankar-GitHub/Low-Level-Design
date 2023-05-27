package com.port.management.exception;

public class InvalidNumberOfFreePortsException extends RuntimeException {

    public InvalidNumberOfFreePortsException() {
        super("Invalid number of free ports");
    }
}
