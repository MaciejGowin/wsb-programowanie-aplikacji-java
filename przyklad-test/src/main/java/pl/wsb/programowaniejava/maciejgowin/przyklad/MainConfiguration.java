package pl.wsb.programowaniejava.maciejgowin.przyklad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("pl.wsb.programowaniejava.maciejgowin")
public class MainConfiguration {

    @Bean
    public Job simpleJob() {
        return new SimpleJob();
    }

    @Bean
    public Job hardJob() {
        return new HardJob();
    }

    @Bean
    public Worker worker() {
        return new Worker();
    }
}
