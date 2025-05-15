package pl.wsb.programowaniejava.maciejgowin.przyklad.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.RyanairApiCountryDto;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AirportService {

    private final RyanairApiService ryanairApiService;

    public Optional<String> getDefaultAirportCode(String countryCode) {
        return ryanairApiService.getCountries()
                .stream()
                .filter(country -> country.getCode() != null && country.getCode().equals(countryCode))
                .findFirst()
                .map(RyanairApiCountryDto::getDefaultAirportCode);
    }
}
