package lesson_19_IO_and_NIO.ChackNorris.N_NIO_BufferAndChannel_methods;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    private final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/N_NIO_BufferAndChannel_methods/BufferAndChannel_methods.txt";

    public static void main(String[] args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(PATH, "r")) {   // будем только читать

            FileChannel channel = randomAccessFile.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(5);

            channel.read(buffer);

            buffer.flip();        //меняет режим из записи в режим чтение  position = 0;

            System.out.println((char)buffer.get()); // читаем о 1 байту
            System.out.println((char)buffer.get());
            System.out.println((char)buffer.get());
            System.out.println("_________________");

            buffer.rewind(); //помещает position опять в 0, можно опять прочитать a b с

            System.out.println((char)buffer.get()); // читаем о 1 байту
            System.out.println((char)buffer.get());
            System.out.println((char)buffer.get());
            System.out.println("_________________");

            buffer.compact();      // позволяет дочитывать буфер на 5 байт до k включительно
            channel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char) buffer.get());
            }
            System.out.println("_________________");
            buffer.clear();
            channel.read(buffer);       // дочитываем остальное
            buffer.flip();
            System.out.println((char)buffer.get()); // читаем о 1 байту
            System.out.println((char)buffer.get());
            System.out.println((char)buffer.get());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
