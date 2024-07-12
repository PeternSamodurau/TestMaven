package Lesson_22_HTTP_protocol.My._6.HTTP_протокол._9.Thread_pool_server;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;

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

        var response1 = httpClient.sendAsync(request, BodyHandlers.ofString()); // получаем ответ сервера асинхронно т е не блокирующий поток
        var response2 = httpClient.sendAsync(request, BodyHandlers.ofString()); // получаем ответ сервера асинхронно т е не блокирующий поток
        var response3 = httpClient.sendAsync(request, BodyHandlers.ofString()); // получаем ответ сервера асинхронно т е не блокирующий поток


        try {
            System.out.println(response1.get().body());
            System.out.println(response2.get().body());
            System.out.println(response3.get().body());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
