package fr.lernejo;

import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import fr.lernejo.navy_battle.Launcher;

import org.junit.jupiter.api.Test;
import java.io.IOException;

public class LauncherTest {
    @Test
    void test_main_too_many_arg() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Launcher.main(new String[] {"21", "31", "44"}))
                .withMessage("Utilisation : [Port HTTP] [Adresse du serveur]");
    }
    @Test
    void test_main_valid_arg() {
        org.assertj.core.api.Assertions.assertThatNoException()
                .isThrownBy(() -> Launcher.main(new String[] {"4007"}));
    }
    @Test
    void test_main_invalid_arg() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Launcher.main(new String[]{"le neuf et le huit"}));
    }
    @Test
    void PingCorect() throws IOException, InterruptedException {

        String[] arg = {"4005"};
        Launcher.main(arg);

        URL test_url = new URL("http://localhost:4000/ping");
        HttpURLConnection connection_test = (HttpURLConnection) test_url.openConnection();
        connection_test.setRequestMethod("GET");

        int response = connection_test.getResponseCode();
        Assertions.assertEquals(response, 200, "Mauvaise réponse");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(connection_test.getInputStream()));

        StringBuilder message = new StringBuilder();
        String string;
        while ((string = buffer.readLine()) != null) {
            message.append(string);
        }
        buffer.close();

        Assertions.assertEquals(message.toString(), "OK", "Bon message !");

    }

    @Test
    void test_main_null_url() {
        org.assertj.core.api.Assertions.assertThatNoException()
                .isThrownBy(() -> Launcher.main(new String[]{"4008", null}));
    }

    
}
