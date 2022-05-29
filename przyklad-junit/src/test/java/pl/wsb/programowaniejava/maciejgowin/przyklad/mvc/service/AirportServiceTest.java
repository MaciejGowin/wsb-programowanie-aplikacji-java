package pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.dto.AirportCodeName;
import pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.dto.AirportName;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AirportServiceTest {

    @InjectMocks
    AirportService airportService;

    @Mock
    RestTemplate restTemplate;

    @Test
    void shouldGetAirportsName() {
        // given
        when(restTemplate.getForObject("https://www.ryanair.com/api/locate/v5/airports/DUB", AirportCodeName.class))
                .thenReturn(new AirportCodeName("DUB", "DUBLIN"));
        // when
        AirportName airportName = airportService.getAirportsName("DUB");
        // then
        assertEquals("dublin", airportName.getName());
        verify(restTemplate, times(1))
                .getForObject("https://www.ryanair.com/api/locate/v5/airports/DUB", AirportCodeName.class);
    }
}