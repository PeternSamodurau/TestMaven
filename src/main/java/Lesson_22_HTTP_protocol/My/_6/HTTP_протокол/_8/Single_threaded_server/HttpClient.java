package Lesson_22_HTTP_protocol.My._6.HTTP_протокол._8.Single_threaded_server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;

public class HttpClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        java.net.http.HttpClient httpClient = java.net.http.HttpClient.newBuilder()
                .version(java.net.http.HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder()  // запрос на http-сервер
                .uri(URI.create("http://localhost:9000"))
                .header("content-type", "application/json")
                .POST(BodyPublishers.ofFile(Path.of("src/main/resources/first.json")))
                .build();

        var response = httpClient.send(request, BodyHandlers.ofString()); // получаем ответ сервера

        System.out.println(response.headers());
        System.out.println(response.body());
    }
}
