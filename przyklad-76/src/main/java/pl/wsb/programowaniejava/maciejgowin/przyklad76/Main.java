package pl.wsb.programowaniejava.maciejgowin.przyklad76;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.wsb.programowaniejava.maciejgowin.przyklad76.service.RouteService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:context.xml");
        RouteService routeService = context.getBean(RouteService.class);
        System.out.println(routeService.getRoutes());
    }
}
