package pl.wsb.programowaniejava.maciejgowin.przyklad;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.wsb.programowaniejava.maciejgowin.przyklad.exception.ResourceNotFoundException;
import pl.wsb.programowaniejava.maciejgowin.przyklad.exception.ValidationException;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.ErrorDto;

@RestControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handle(ResourceNotFoundException ex) {
        return ErrorDto.builder().message(ex.getMessage()).build();
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handle(ValidationException ex) {
        return ErrorDto.builder().message(ex.getMessage()).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handle(Exception ex) {
        return ErrorDto.builder().message("Something went wrong").build();
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
        return new ResponseEntity<>(ErrorDto.builder().message("Method not allowed").build(), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
