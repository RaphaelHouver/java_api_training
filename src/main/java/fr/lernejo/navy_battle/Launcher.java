package fr.lernejo.navy_battle;
import java.io.IOException;
public class Launcher {
    public static void main(String[] args) throws IOException {
        if (args.length < 1 || args.length > 2) {
            throw new IllegalArgumentException("Utilisation : [Port HTTP] [Adresse du serveur]");
        }
        if (args.length == 1) {
            try {
                MyHttpServer httpserver = new MyHttpServer(args[0]);
                httpserver.createServer();
            } catch (Exception e) {
                throw new IllegalArgumentException("Utilisation : [Port HTTP] [Adresse du serveur]");
            }
        }

    }
}
