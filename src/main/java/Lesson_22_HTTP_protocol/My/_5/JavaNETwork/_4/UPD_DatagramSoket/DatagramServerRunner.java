package Lesson_22_HTTP_protocol.My._5.JavaNETwork._4.UPD_DatagramSoket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServerRunner {
    public static void main(String[] args) {
        try (DatagramSocket datagramServer = new DatagramSocket(7777)) {

            byte[] bytes = new byte[512];

            DatagramPacket packet = new DatagramPacket(bytes, bytes.length); // создаем пакет

            datagramServer.receive(packet); // получаем пакет

            System.out.println("From client : " + new String(packet.getData())); // печатаем содержимое packet


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
