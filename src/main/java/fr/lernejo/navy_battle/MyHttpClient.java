package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {

    private final int port;
    private final HttpClient client;

    public MyHttpClient(int p) {
        this.port = p;
        this.client = HttpClient.newHttpClient();
    }

    public HttpRequest NewClient(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url + "/api/game/start"))
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"hello\"}"))
                .build();
    }

    public void send(String url) throws IOException, InterruptedException {
        HttpRequest post = NewClient(url);
        HttpResponse<String> response = this.client.send(post, HttpResponse.BodyHandlers.ofString());
    }
}

