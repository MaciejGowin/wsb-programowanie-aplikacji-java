package pl.wsb.programowaniejava.maciejgowin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {

    @GetMapping("/")
    @ResponseBody
    public String getRoot() {
        return "root";
    }

    @PostMapping("/")
    @ResponseBody
    public String postRoot(@RequestBody String root) {
        return "post-" + root;
    }

    @GetMapping("/test")
    @ResponseBody
    public TestDto getTest() {
        return TestDto.builder().test("test").build();
    }

    @PostMapping("/test")
    @ResponseBody
    public TestDto postTest(@RequestBody TestDto testDto) {
        return TestDto.builder().test("post-" + testDto.getTest()).build();
    }
}
