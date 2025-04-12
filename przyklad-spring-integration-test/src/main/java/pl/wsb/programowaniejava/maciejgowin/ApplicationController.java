package pl.wsb.programowaniejava.maciejgowin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ApplicationController {

    private final ExampleService exampleService;

    @GetMapping("/example")
    public String example() {
        return exampleService.getValue();
    }
}
