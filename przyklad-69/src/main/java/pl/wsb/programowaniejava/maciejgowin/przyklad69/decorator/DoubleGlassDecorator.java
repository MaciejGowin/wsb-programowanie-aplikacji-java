package pl.wsb.programowaniejava.maciejgowin.przyklad69.decorator;

public class DoubleGlassDecorator extends WindowDecorator {

    public DoubleGlassDecorator(Window decoratedWindow) {
        super(decoratedWindow);
    }

    @Override
    public String print() {
        return "||" + super.print() + "||";
    }
}
