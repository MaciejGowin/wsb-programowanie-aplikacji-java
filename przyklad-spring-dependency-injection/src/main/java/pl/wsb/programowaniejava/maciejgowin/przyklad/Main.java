package pl.wsb.programowaniejava.maciejgowin.przyklad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Worker worker = context.getBean(Worker.class);
        worker.job();
    }
}
