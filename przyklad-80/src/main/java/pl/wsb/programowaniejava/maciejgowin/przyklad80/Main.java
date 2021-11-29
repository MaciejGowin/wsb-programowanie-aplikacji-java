package pl.wsb.programowaniejava.maciejgowin.przyklad80;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new BasicHttpHandler());
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.start();
        System.out.println("Server started");
    }

    static class BasicHttpHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            if ("GET".equals(httpExchange.getRequestMethod())) {
                response(httpExchange, 200, "Requested: " + httpExchange.getRequestURI());
            } else {
                response(httpExchange, 405, "Invalid method");
            }
        }

        public void response(HttpExchange httpExchange, int code, String content) throws IOException {
            httpExchange.sendResponseHeaders(code, content.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(content.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
}
