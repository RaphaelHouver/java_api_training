package fr.lernejo.navy_battle;
import java.io.IOException;
public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1 || args.length > 2) {
            throw new IllegalArgumentException("Utilisation : [Port HTTP] [Adresse du serveur]");
        }
        if (args.length == 1) {
                MyHttpServer httpserver = new MyHttpServer(args[0], null);
                httpserver.createServer();
        }
        else {
                MyHttpServer httpserver = new MyHttpServer(args[0], args[1]);
                httpserver.createServer();
        }

    }
}
