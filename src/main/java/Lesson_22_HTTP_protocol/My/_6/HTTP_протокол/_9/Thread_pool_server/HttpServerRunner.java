package Lesson_22_HTTP_protocol.My._6.HTTP_протокол._9.Thread_pool_server;

// этот сервер будет плохо работать с множеством клиентов и множеством запросов так как метод accept() блокирующий пока не получим запрос и не отправим ответ

public class HttpServerRunner {

    public static void main(String[] args) {
        int countOfConnections = 100;

        HttpServer server = new HttpServer(9000, countOfConnections);
        server.start();
        server.stop(true);

    }
}
