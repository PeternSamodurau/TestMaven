package Lesson_22_HTTP_protocol.My._5.JavaNETwork._3.TCP_Server_socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
// сервер на стороне java по протоколу tcp
// ЗАПУСКАЕМ СНАЧАЛА СЕРВЕР

public class Main {

    public static String PATH = "src/main/java/Lesson_22_HTTP_protocol/My/_5/JavaNETwork/_3/TCP_Server_socket/output.txt";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept();

             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

             Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter(PATH, true)) {

            String request = dataInputStream.readUTF(); // ОЖИДАЕМ ЗАПРОС ОТ КЛИЕНТА , ПЕРЕХОДИМ НА КЛИЕНТ , ОТПРАВЛЯЕМ ЗАПРОС НА КЛИЕНТЕ

            while (!request.equals("stop")) {

                System.out.println("Client request : " + request);
                writer.write("Client request : " + request + "\n");

                String response = scanner.nextLine();
                System.out.println("Server response : " + response);
                writer.write("Server response : " + response + "\n");

                dataOutputStream.writeUTF(response);     // ОТВЕТ СЕРВЕРА
                request = dataInputStream.readUTF();

                writer.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
