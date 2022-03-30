package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import javax.security.auth.callback.CallbackHandler;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class MyHttpServer {
    private final int port;
    private final String url;

    public MyHttpServer(String p, String u) {
        this.port = Integer.parseInt(p);
        this.url = u;
    }

    public void createServer() throws IOException, InterruptedException {
        System.out.println("Initialisation du serveur http...");
        HttpServer server = HttpServer.create(new InetSocketAddress(this.port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new PingHandler());
        //server.createContext("api/game/start", new StartHandler(this));
        server.start();
        if (this.url != null) {
            MyHttpClient c = new MyHttpClient(this.port);
            c.send(this.url);
        }
    }

}