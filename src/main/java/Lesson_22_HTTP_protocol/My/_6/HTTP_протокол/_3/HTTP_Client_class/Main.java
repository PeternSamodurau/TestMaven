package Lesson_22_HTTP_protocol.My._6.HTTP_протокол._3.HTTP_Client_class;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//выступает клиентом на стороне java к серверу который принимает http-запросы
public class Main {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build(); //создаем клиент

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com")).GET().build();
        HttpRequest request1 = HttpRequest.newBuilder(URI.create("https://www.google.com")).POST(HttpRequest.BodyPublishers.ofString("Hello")).build();

        try {
            HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
            System.out.println("---------------------------------");
            System.out.println(response.headers());

            HttpResponse response1 = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response1.body());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
