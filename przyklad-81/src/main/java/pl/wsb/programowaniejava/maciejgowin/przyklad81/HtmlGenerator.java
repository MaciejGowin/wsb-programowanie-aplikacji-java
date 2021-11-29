package pl.wsb.programowaniejava.maciejgowin.przyklad81;

public class HtmlGenerator {

    public static String withBody(String body, String color) {
        return "<html>" +
                "<body style=\"background: " + color + "\">" +
                body +
                "</body>" +
                "</html>";
    }
}
