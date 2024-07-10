package Lesson_22_HTTP_protocol.My._5.JavaNETwork._4.UPD_DatagramSoket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// это клиент на стороне java по протоколу udp
// сервер не ругается по этому протоколу, он не проверяет входящие данные, даже если сервер не поднят
public class DatagramClientRunner {

    public static void main(String[] args) {
        try {
            InetAddress inet4Address = InetAddress.getByName("localhost");
            DatagramSocket datagramClient = new DatagramSocket(); // создаем сокет, куда будем отправлять данные

            byte[] bytes = new byte[512]; // какой-то массив байтов, который заполняют, отправляются на сервер и получаются от него
            String message = "Hello, Server from UDP client"; // сообщение, которое будем отправлять
            bytes = message.getBytes(); // конвертируем строку в байты

            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, inet4Address, 7777);

            datagramClient.send(packet); // отправляем пакет на сервер

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
