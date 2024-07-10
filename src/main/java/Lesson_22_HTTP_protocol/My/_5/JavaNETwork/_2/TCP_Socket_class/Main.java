package Lesson_22_HTTP_protocol.My._5.JavaNETwork._2.TCP_Socket_class;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// это клиент на стороне java по протоколу tcp
// ЗАПУСКАЕМ СНАЧАЛА СЕРВЕР КОТОРЫЙ НАДО ОРГАНИЗОВАТЬ НА ЭТОМ КОМПЬЮТЕРЕ, СМ ПОДКЛЮЧЕНИЕ К СЕРВЕРУ НИЖЕ
public class Main {

    public static String PATH = "src/main/java/Lesson_22_HTTP_protocol/My/_5/JavaNETwork/_3/TCP_Server_socket/output.txt";

    public static void main(String[] args) throws UnknownHostException {
        InetAddress name = Inet4Address.getByName("localhost"); // получаем ip адрес сайта google.com
        try (
                Socket socket = new Socket(name, 7777);   // http-7777 порт, https-443 порт, tcp-протокол

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                Scanner scanner = new Scanner(System.in);
                FileWriter writer = new FileWriter(PATH, true)) {

            System.out.println(socket.getInetAddress());
            while (scanner.hasNextLine()) {
                String request = scanner.nextLine(); // получаем строку из scanner.n это будет запросом

                System.out.println("Client request: " + request);
                writer.write("Client request: " + request + "\n");

                dataOutputStream.writeUTF(request); // отправляем строку на сервер
                System.out.println("Response from server: " + dataInputStream.readUTF());
                writer.write("Response from server: " + dataInputStream.readUTF() + "\n");

                writer.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
