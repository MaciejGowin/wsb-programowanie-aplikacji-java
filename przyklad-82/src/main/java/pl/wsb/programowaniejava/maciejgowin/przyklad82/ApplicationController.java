package pl.wsb.programowaniejava.maciejgowin.przyklad82;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;

@Controller
public class ApplicationController {

    @RequestMapping("/**")
    public String root(ModelMap model, HttpServletRequest request) {
        model.addAttribute("time", OffsetDateTime.now());
        model.addAttribute("url", request.getRequestURI());
        return "root";
    }

    @RequestMapping("/sample")
    public ModelAndView sample(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sample");
        modelAndView.addObject("time", OffsetDateTime.now());
        modelAndView.addObject("url", request.getRequestURI());
        return modelAndView;
    }
}
