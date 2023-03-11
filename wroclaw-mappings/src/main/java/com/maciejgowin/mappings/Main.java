package com.maciejgowin.mappings;

import java.util.Map;

class FirstThread extends Thread {

    private Map<String, String> map;

    public FirstThread(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = Map.of();

        Thread firstThread = new FirstThread(map);
        firstThread.start();


        Thread seco = new FirstThread(map);
        seco.start();;
    }
}
