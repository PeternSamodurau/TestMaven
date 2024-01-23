package lesson_19.NIO_API_19_6;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ByteBuffer_Write_Read {
    public static void main(String[] args) {
        //ЗАПИСЬ В БУФЕР
        // Рассмотрим способы передачи на примере того же универсального подкласса ByteBuffer,
        // который может передавать данные разных типов (числа и символы).
        // Данные для записи и чтения могут передаваться как по одному байту, так и в виде массива.
        ByteBuffer buffer = ByteBuffer.allocate(32);
        // Метод allocate () класса java.nio.ByteBuffer используется для выделения нового байтового буфера.
        //Позиция нового буфера будет равна нулю, его пределом будет его емкость,
        // его метка будет неопределенной, и каждый из его элементов будет инициализирован нулем.
        // У него будет резервный массив, и его смещение массива будет нулевым.
        buffer.put((byte) 'H');                                // буфер содержит [H]
        buffer.put("ello world".getBytes());                   // буфер содержит [Hello world]
        buffer.put(6, "Skillbox".getBytes());            // буфер содержит [Hello Skillbox]

        //ЧТЕНИЕ ИЗ БУФЕРА
        buffer.flip();                                          // переводим в position = 0, limit = 11

        char h = (char) buffer.get();                           // position = 1, char = 'H'
        System.out.println(h);
        char h1 = (char) buffer.get();                          // position = 2, char = 'e'
        System.out.println(h1);
        char h3 = (char) buffer.get(6);                         // position = 2, char = 'S', чтение по конкретному индексу, позиция не меняется!
        System.out.println(h3);

        byte[] hello = new byte[5];                              // выделяем массив 5 элементов
        buffer.get(0, hello); // чтение с индекса 0 массива байт и запись в массив hello, заполнится массив hello данными с 0 индекса по 4 включительно
        for (byte b:hello){
            System.out.println( b+ " ");
        }
        String result = new String(hello, StandardCharsets.UTF_8);  // пореводим массив байт
        System.out.println(result); // Hello

        char x = (char) buffer.get(12); // IndexOutOfBoundsException, обращаемся к существующему символу 'o', но за пределами limit, равного 11
    }
}
