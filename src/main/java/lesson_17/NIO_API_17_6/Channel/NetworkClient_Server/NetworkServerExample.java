package lesson_17.NIO_API_17_6.Channel.NetworkClient_Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NetworkServerExample {
    //Передача данных не ограничивается локальной системой,
    // так как NIO API позволяет передавать информацию через сетевое подключение.
    // В качестве примера реализуем клиент-серверное соединение, используя имеющиеся базовые инструменты.
    // если ваш порт занят, укажите свободный порт
    private static final int PORT = 8088;

    public static void main(String[] args) throws IOException {
        //Создадим два класса.
        //Серверный (NetworkServerExample) для приёма сообщения:

        //создаёт серверный сокет-канал и привязывает его к порту 8088;
        //ожидает подключение клиента;
        //принимает сообщение от клиента;
        //закрывает сокет-каналы.
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
        System.out.println("Server started on port " + PORT);

        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("Client connected: " + socketChannel.getRemoteAddress());

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(buffer);
        String message = new String(buffer.array(), 0, bytesRead);
        System.out.println("Received message from client: " + message);

        socketChannel.close();
        serverSocketChannel.close();

    }
}


