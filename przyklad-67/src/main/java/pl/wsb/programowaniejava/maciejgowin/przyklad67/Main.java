package pl.wsb.programowaniejava.maciejgowin.przyklad67;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 1000; i++) {
            Runnable runnable = () -> {
                System.out.println(Thread.currentThread().getName());
            };
            Callable<String> callable = () -> {
                System.out.println(Thread.currentThread().getName());
                return "a";
            };
            Future<String> a = executorService.submit(callable);
            a.g
        }
        executorService.shutdown();
    }
}
