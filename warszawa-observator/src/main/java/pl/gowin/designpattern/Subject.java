package pl.gowin.designpattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void publish(String message) {
        observers.forEach(observer -> observer.consume(message));
    }
}
