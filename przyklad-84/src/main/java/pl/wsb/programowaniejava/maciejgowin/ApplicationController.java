package pl.wsb.programowaniejava.maciejgowin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public ModelAndView root() {
        return new ModelAndView("root");
    }
}
