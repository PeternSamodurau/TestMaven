package lesson_19_IO_and_NIO.ChackNorris.F_DataInputStream_DataOutputStream;

//DataInputStream_DataOutputStream записывают и читают примитивные типы данных

import lombok.Data;

import java.io.*;

public class Main {

    private final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/F_DataInputStream_DataOutputStream/data.bin";

    public static void main(String[] args) {
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(PATH));
             DataInputStream inputStream = new DataInputStream(new FileInputStream(PATH))){

            outputStream.writeChar('A');
            outputStream.writeBoolean(true);
            outputStream.writeInt(5);
            outputStream.writeChars("a");

            System.out.println(inputStream.readChar());
            System.out.println(inputStream.readBoolean());
            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readChar());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
