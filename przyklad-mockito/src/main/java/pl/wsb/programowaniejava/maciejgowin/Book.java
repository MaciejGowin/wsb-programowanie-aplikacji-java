package pl.wsb.programowaniejava.maciejgowin;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Book {

    private final int id;
    private final String title;
}
