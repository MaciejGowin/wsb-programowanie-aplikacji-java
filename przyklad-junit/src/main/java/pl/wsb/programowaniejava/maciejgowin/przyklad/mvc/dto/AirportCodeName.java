package pl.wsb.programowaniejava.maciejgowin.przyklad.mvc.dto;

public class AirportCodeName extends AirportName {

    public AirportCodeName(String code, String name) {
        super(name);
        this.code = code;
    }

    private String code;
}
