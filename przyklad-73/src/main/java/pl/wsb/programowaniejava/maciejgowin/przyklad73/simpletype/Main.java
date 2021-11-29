package pl.wsb.programowaniejava.maciejgowin.przyklad73.simpletype;

import com.fasterxml.jackson.databind.ObjectMapper;

import static pl.wsb.programowaniejava.maciejgowin.przyklad73.util.ClassPathFile.readFile;

public class Main {

    public static void main(String[] args) throws Exception {
        City wroclaw = City.builder()
                .name("Wroclaw")
                .capital(false)
                .population(700000)
                .area(123.123)
                .country(Country.builder().name("Poland").build())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(wroclaw));
        System.out.println(objectMapper.readValue(readFile("warsaw.json"), City.class));
    }
}
