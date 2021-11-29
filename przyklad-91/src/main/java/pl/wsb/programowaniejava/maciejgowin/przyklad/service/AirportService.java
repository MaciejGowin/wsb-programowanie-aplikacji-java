package pl.wsb.programowaniejava.maciejgowin.przyklad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.RyanairApiCountryDto;

import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private RyanairApiService ryanairApiService;

    public Optional<String> getDefaultAirportCode(String countryCode) {
        return ryanairApiService.getCountries()
                .stream()
                .filter(country -> country.getCode() != null && country.getCode().equals(countryCode))
                .findFirst()
                .map(RyanairApiCountryDto::getDefaultAirportCode);
    }
}
