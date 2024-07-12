package Lesson_22_HTTP_protocol.My._6.HTTP_протокол._2.URL_class;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//устаревший способ, класс URL работает по протоколу http

public class Main {
    public static void main(String[] args) throws IOException {
//        URL url = new URL("file:src/main/java/Lesson_22_HTTP_protocol/My/_5/JavaNETwork/_4/UPD_DatagramSoket/DatagramClientRunner.java");
//        URLConnection connection = url.openConnection();
//        System.out.println(new String(connection.getInputStream().readAllBytes()));

        checkGoogle();

    }

    private static void checkGoogle() {
        try {
            URL url = new URL("https://www.google.com");
            URLConnection connection = url.openConnection();

            System.out.println(connection.getURL()); // get url
            System.out.println(new String(connection.getInputStream().readAllBytes())); // get response



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
