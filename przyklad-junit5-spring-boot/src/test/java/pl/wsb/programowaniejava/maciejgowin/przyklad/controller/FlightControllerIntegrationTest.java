package pl.wsb.programowaniejava.maciejgowin.przyklad.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.wsb.programowaniejava.maciejgowin.przyklad.model.Flight;
import pl.wsb.programowaniejava.maciejgowin.przyklad.service.FlightService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestPropertySource("classpath:application-test.properties")
@SpringBootTest
@AutoConfigureMockMvc
class FlightControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    // TODO: Remove mock and use actual service for the IntegrationTest
    @MockBean
    FlightService flightService;

    @Test
    void shouldReturnNoFlights() throws Exception {
        // given
        when(flightService.findAllFlights()).thenReturn(List.of());

        // when & then
        MvcResult result = mockMvc.perform(get("/flights"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("[]"))
                .andReturn();
    }

    @Test
    void shouldReturnFlights() throws Exception {
        // given
        Flight flight = Flight.builder()
                .id(1L)
                .flightNo("123")
                .noOfPassengers(2)
                .build();

        when(flightService.findAllFlights()).thenReturn(List.of(flight));

        // when & then
        MvcResult result = mockMvc.perform(get("/flights"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("[{\"id\":1,\"flightNo\":\"123\",\"noOfPassengers\":2}]"))
                .andReturn();
    }
}