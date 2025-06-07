package pl.wsb.programowaniejava.maciejgowin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationControllerTestRestTemplateTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldReturnExample() {
        // given && when
        String result = testRestTemplate.getForObject("/example", String.class);

        // then
        assertEquals("example-value", result);
    }
}
