package pl.wsb.programowaniejava.maciejgowin.przyklad68;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Started processing");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<String>> futures = Stream.of(100, 200, 100, 300, 400, 600)
                .map(Main::getCallable)
                .map(executorService::submit)
                .collect(Collectors.toList());

        futures.stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception ex) {
                        return ex.getMessage();
                    }
                })
                .forEach(System.out::println);

        executorService.shutdown();

        System.out.println("Finished processing");
    }

    public static Callable<String> getCallable(final int sleep) {
        return () -> {
            Thread.sleep(sleep);
            return String.format("Thread: %s: finished task: %s",
                    Thread.currentThread().getName(), OffsetDateTime.now());
        };
    }
}
