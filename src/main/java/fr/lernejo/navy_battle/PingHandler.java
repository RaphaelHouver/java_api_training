package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class PingHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200,2);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write("OK".getBytes());
        }
    }
}