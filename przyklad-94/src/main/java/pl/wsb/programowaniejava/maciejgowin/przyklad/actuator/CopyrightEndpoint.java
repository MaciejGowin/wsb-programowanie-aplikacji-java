package pl.wsb.programowaniejava.maciejgowin.przyklad.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.Map;

@Component
@Endpoint(id = "copyright")
public class CopyrightEndpoint {

    @ReadOperation
    public Map<String, String> copyright() {
        return Map.of("author", "Maciej Gowin", "year", Year.now().toString());
    }
}
