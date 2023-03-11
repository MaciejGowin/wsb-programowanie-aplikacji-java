package pl.gowin.designpattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test");

        Observer observer1 = new Observer(1);
        Observer observer2 = new Observer(2);

        Subject subject = new Subject();
        subject.add(observer1);
        subject.publish("Hello");

        subject.add(observer2);
        subject.publish("Eluwina");
    }
}
