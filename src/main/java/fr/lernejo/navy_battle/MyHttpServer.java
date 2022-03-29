package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import javax.security.auth.callback.CallbackHandler;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class MyHttpServer {
    private final int port;

    public MyHttpServer(String p) {
        this.port = Integer.parseInt(p);
    }

    public void createServer() throws IOException {
        System.out.println("Initialisation du serveur http...");
        HttpServer server = HttpServer.create(new InetSocketAddress(this.port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new PingHandler());
        server.start();
    }

}