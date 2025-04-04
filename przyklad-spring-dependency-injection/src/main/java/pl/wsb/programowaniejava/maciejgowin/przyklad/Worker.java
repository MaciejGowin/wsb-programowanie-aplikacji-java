package pl.wsb.programowaniejava.maciejgowin.przyklad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Worker {

    @Autowired
    @Qualifier("hardJob")
    private Job job;

    public void job() {
        job.job();
    }
}
