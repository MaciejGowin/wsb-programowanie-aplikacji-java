package pl.wsb.programowaniejava.maciejgowin.przyklad.exception;

import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

public final class BindingResultSupport {

    public static String asMessage(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(e -> e.getObjectName() + "." + e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));
    }
}
