package pl.wsb.programowaniejava.maciejgowin.przyklad69.decorator;

public class Main {

    public static void main(String[] args) {
        Window window1 = new ArtisticFrameDecorator(new BasicWindow());
        Window window2 = new ArtisticFrameDecorator(new DoubleGlassDecorator(new BasicWindow()));

        System.out.printf("Window 1: %s%n", window1.print());
        System.out.printf("Window 2: %s%n", window2.print());
    }
}
