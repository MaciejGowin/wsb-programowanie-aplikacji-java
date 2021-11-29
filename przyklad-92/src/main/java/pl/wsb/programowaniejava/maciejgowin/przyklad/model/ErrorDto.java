package pl.wsb.programowaniejava.maciejgowin.przyklad.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorDto {

    public final String message;
}
