package pl.gowin.designpattern;

public class Observer {

    private int id;

    public Observer(int id) {
        this.id = id;
    }

    public void consume(String message) {
        System.out.printf("%d %s\n", id, message);
    }
}
