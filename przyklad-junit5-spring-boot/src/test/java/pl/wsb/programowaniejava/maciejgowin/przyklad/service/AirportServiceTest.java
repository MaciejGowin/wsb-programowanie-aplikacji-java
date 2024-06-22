package pl.wsb.programowaniejava.maciejgowin.przyklad.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import pl.wsb.programowaniejava.maciejgowin.przyklad.dto.AirportCodeNameDto;

import static org.assertj.core.api.Assertions.assertThat;
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
        when(restTemplate.getForObject("https://www.ryanair.com/api/views/locate/5/airports/en/DUB", AirportCodeNameDto.class))
                .thenReturn(new AirportCodeNameDto("DUB", "DUBLIN"));

        // when
        String airportName = airportService.getAirportsName("DUB");

        // then
        assertThat(airportName).isEqualTo("dublin");
        verify(restTemplate, times(1))
                .getForObject("https://www.ryanair.com/api/views/locate/5/airports/en/DUB", AirportCodeNameDto.class);
    }
}