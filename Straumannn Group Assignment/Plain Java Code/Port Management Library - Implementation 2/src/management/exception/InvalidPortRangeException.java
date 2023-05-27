package management.exception;

public class InvalidPortRangeException extends RuntimeException {

    public InvalidPortRangeException() {
        super("Invalid port range");
    }
}
