package pl.wsb.programowaniejava.maciejgowin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("/example")
    public String example() {
        return exampleService.getValue();
    }
}
