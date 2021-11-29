package pl.wsb.programowaniejava.maciejgowin.przyklad.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.RyanairApiCountryDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class RyanairApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RyanairApiService.class);

    @Value("${ryanairApi.countries.endpoint}")
    private String ryanairApiCountriesEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    public List<RyanairApiCountryDto> getCountries() {
        try {
            RyanairApiCountryDto[] countries = restTemplate.getForObject(ryanairApiCountriesEndpoint, RyanairApiCountryDto[].class);
            return ofNullable(countries).map(Arrays::asList).orElseGet(Collections::emptyList);
        } catch (Exception ex) {
            LOGGER.warn("Failed to load data from Ryanair API: {}",  ex.getMessage(), ex);
            return List.of();
        }
    }
}
