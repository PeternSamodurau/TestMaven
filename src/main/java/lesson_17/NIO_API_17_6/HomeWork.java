package lesson_17.NIO_API_17_6;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class HomeWork {
    public static void main(String[] args) {
        ByteBuffer buff = ByteBuffer.allocate(32); // mark = -1, position = 0, limit = 32, capacity = 32

        buff.mark(); // mark = 0, position = 0, limit = 32, capacity = 32
        buff.put("Byte".getBytes());// mark = 0, position = 4, limit = 32, capacity = 32
        buff.reset(); // mark = 0, position = 0, limit = 32, capacity = 32
        buff.put("Buffer are part of NIO".getBytes()); // mark = 0, position = 22, limit = 32, capacity = 32
        buff.limit(30); // mark = 0, position = 22, limit = 30, capacity = 32
        buff.flip(); // mark = -1, position = 0, limit = 22, capacity = 32        // меняем запись на чтение

        byte[] result = new byte[buff.limit()];
        buff.get(result); // mark = -1, position = 22, limit = 22, capacity = 32
        System.out.println(new String(result, StandardCharsets.UTF_8)); // Buffer are part of NIO
    }
}
