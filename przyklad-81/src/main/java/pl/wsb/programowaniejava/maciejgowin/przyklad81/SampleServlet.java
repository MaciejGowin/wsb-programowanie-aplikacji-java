package pl.wsb.programowaniejava.maciejgowin.przyklad81;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.OffsetDateTime;

public class SampleServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.getWriter().print(HtmlGenerator.withBody("Sample: " + req.getRequestURI() + " " + OffsetDateTime.now(), "red"));
        resp.getWriter().flush();
    }
}
