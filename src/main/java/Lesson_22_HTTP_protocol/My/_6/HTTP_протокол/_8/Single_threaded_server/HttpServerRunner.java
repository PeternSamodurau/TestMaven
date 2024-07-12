package Lesson_22_HTTP_protocol.My._6.HTTP_протокол._8.Single_threaded_server;

// этот сервер будет плохо работать с множеством клиентов и множеством запросов так как метод accept() блокирующий пока не получим запрос и не отправим ответ

public class HttpServerRunner {
    public static void main(String[] args) {
        HttpServer server = new HttpServer(9000);
        server.start();
    }
}
