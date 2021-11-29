package pl.wsb.programowaniejava.maciejgowin.przyklad69.decorator;

public class ArtisticFrameDecorator extends WindowDecorator {

    public ArtisticFrameDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    @Override
    public String print() {
        return "{" + super.print() + "}";
    }
}
