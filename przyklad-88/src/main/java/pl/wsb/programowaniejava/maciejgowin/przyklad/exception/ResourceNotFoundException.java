package pl.wsb.programowaniejava.maciejgowin.przyklad.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Resource not found");
    }
}
