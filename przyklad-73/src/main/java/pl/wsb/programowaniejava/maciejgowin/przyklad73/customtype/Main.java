package pl.wsb.programowaniejava.maciejgowin.przyklad73.customtype;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import static pl.wsb.programowaniejava.maciejgowin.przyklad73.util.ClassPathFile.readFile;

public class Main {

    public static void main(String[] args) throws Exception {
        Person janNowak = Person.builder()
                .firstName("Jan")
                .lastName("Nowak")
                .dateOfBirth(LocalDate.parse("1970-04-18"))
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(janNowak));
        System.out.println(objectMapper.readValue(readFile("andrzejKowalski.json"), Person.class));
    }
}
