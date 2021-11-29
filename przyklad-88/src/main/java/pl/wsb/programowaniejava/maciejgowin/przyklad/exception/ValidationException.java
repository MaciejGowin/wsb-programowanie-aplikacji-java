package pl.wsb.programowaniejava.maciejgowin.przyklad.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String property) {
        super("Invalid property value: " + property);
    }
}
