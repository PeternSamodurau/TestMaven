package lesson_19.NIO_API_19_6.Channel.Selector;
//Селекторы используются для одновременного обслуживания нескольких каналов ввода-вывода в одном потоке.
// Это позволяет обрабатывать несколько соединений в одном потоке
// и может быть полезно для обработки большого количества соединений или повышения производительности ввода-вывода.

//С помощью селектора можно регистрировать каналы, которые могут быть готовы к операциям (OP) чтения (OP_READ), записи (OP_WRITE),
// подключения (OP_CONNECT) или принятия нового соединения (OP_ACCEPT).
// Селектор также позволяет определять, какие каналы готовы к обработке ввода-вывода, и в соответствии с этим обрабатывать их.
// Это сильно упрощает код для работы с несколькими каналами ввода-вывода и
// устраняет необходимость использования нескольких потоков для обработки каждого соединения.

//Селекторы также могут использоваться для реализации асинхронного ввода-вывода, когда приложение может продолжать работу,
// в то время как данные считываются или записываются в фоновом режиме. Это может улучшить производительность и отзывчивость приложения.
// см схему data/pic_3.jpg

//ПРИМЕР С СЕРВЕРОМ И ТРЕМЯ КЛИЕНТАМИ

//Создадим класс, имитирующий работу сервера SelectorServerExample:

//создаёт селектор;
//создаёт два серверных канала и регистрирует их в селекторе;
//блокирует работу до поднятия каналов;
//получает ключи для каналов;
//проверяет подключение от клиентов;
//считывает данные из канала в буфер и выводит их в консоль.

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorServerExample {
    private static final int PORT1 = 8088;
    private static final int PORT2 = 8089;

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost", PORT1));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
        serverSocketChannel2.socket().bind(new InetSocketAddress("localhost", PORT2));
        serverSocketChannel2.configureBlocking(false);
        serverSocketChannel2.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();

            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {

                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = serverChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("Новое подключение: " + clientChannel);
                } else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    String message = new String(buffer.array()).trim();
                    System.out.println("Получено сообщение от " + channel + ": " + message);
                }
                keyIterator.remove();
            }
        }
    }
}
