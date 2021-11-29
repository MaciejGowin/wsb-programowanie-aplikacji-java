package pl.wsb.programowaniejava.maciejgowin.przyklad69.decorator;

public abstract class WindowDecorator implements Window {

    private final Window decoratedWindow;

    public WindowDecorator(Window decoratedWindow) {
        this.decoratedWindow = decoratedWindow;
    }

    @Override
    public String print() {
        return decoratedWindow.print();
    }
}
