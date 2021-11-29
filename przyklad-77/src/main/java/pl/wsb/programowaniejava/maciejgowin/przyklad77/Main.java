package pl.wsb.programowaniejava.maciejgowin.przyklad77;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.wsb.programowaniejava.maciejgowin.przyklad77.service.RouteService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        RouteService routeService = context.getBean(RouteService.class);
        System.out.println(routeService.getRoutes());
    }
}
