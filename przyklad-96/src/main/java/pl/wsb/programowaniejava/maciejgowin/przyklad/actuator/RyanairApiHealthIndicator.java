package pl.wsb.programowaniejava.maciejgowin.przyklad.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import pl.wsb.programowaniejava.maciejgowin.przyklad.service.RyanairApiService;

import static java.util.Optional.ofNullable;

@Component
public class RyanairApiHealthIndicator implements HealthIndicator {

    @Autowired
    private RyanairApiService ryanairApiService;

    @Override
    public Health health() {
        return ofNullable(ryanairApiService.getCountries())
                .filter(v -> v.size() > 0)
                .map(v -> Health.up())
                .orElseGet(Health::down)
                .build();
    }
}
