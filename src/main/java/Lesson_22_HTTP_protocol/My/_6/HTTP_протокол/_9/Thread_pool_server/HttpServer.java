package Lesson_22_HTTP_protocol.My._6.HTTP_протокол._9.Thread_pool_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// напишем web сервер, который принимает http-запросы и отвечает на них
//как внутри выглядит сервер Tomcat

public class HttpServer {
    private final ExecutorService pool;
    private final int PORT;
    private boolean stopped;

    public HttpServer(int port, int poolSize) {
        this.pool = Executors.newFixedThreadPool(poolSize);  // создаем пул потоков для обработки запросов на сервере на 100 потоков
        this.PORT = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) { // serverSocket - серверный сокет, ждем соединения на порту 9000 пока не получим запрос
            while (!stopped) {        // запускаем в бесконечном цикле потоки которые будут обрабатывать запросы на сервере
                Socket socket = serverSocket.accept();
                System.out.println("Socket accepted !");     // увидим что не дожидаясь получения запроса сокет принимает соединение
                pool.submit(() -> processSocket(socket));      // теперь запускаем в пуле потоков на несколько запросов в один момент времени

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
            System.out.println("Request: " + new String(inputStream.readNBytes(400))); // readNBytes - читает данные из потока в байтах, упрощаем читаем первые 400 байт

            try {
                Thread.sleep(10000);               // задержка на 10 секунд для примера производительности потока при обработке запроса
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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

    public void stop(boolean stopped) {  // останавливает только потоки , но не закрывает сервер сокет
        this.stopped = stopped;
    }
}
