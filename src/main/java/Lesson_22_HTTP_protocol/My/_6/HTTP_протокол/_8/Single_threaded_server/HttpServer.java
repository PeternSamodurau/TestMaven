package Lesson_22_HTTP_protocol.My._6.HTTP_протокол._8.Single_threaded_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

// напишем web сервер, который принимает http-запросы и отвечает на них
//как внутри выглядит сервер Tomcat

public class HttpServer {

    private final int PORT;

    public HttpServer(int port) {
        this.PORT = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) { // serverSocket - серверный сокет, ждем соединения на порту 9000 пока не получим запрос
            while (true) {
                Socket socket = serverSocket.accept();              //accept - блокирующий метод, поток ждет пока не обработается запрос, только потом следующий
                                                                    // это плохо много клиентов не может обрабатывать
                processSocket(socket);                               //процесс соединения
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    private void processSocket(Socket socket) {
        try (socket;                                                                    // помещаем чтобы не забыть закрыть
             InputStream inputStream = new DataInputStream(socket.getInputStream());// inputStream - поток для чтения данных сокета
             OutputStream outputStream = new DataOutputStream(socket.getOutputStream())) { // outputStream - поток вывода данных сокета
             // step 1 - обработка запроса
            System.out.println("Request: " + new String(inputStream.readNBytes(400))); // readNBytes - читает данные из потока в байтах
             // step 2 -создание ответа
            byte[] body = Files.readAllBytes(Path.of("src/main/resources/example.html")); // readAllBytes - читает все байты из файла

            String headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length);
            outputStream.write(headers.getBytes(StandardCharsets.UTF_8)); // write - запись в поток
            outputStream.write(System.lineSeparator().getBytes()); // write - запись в поток пустая строка отделяет headers от body
            outputStream.write(body); // write - запись в поток

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
