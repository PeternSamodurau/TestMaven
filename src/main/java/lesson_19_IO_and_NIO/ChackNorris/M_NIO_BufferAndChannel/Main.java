package lesson_19_IO_and_NIO.ChackNorris.M_NIO_BufferAndChannel;

//Buffer - блок памяти в который мы можем записывать информацию и читать ее
//Channel - в отличие от стримов может как читать файл так и записывать

//Чтение файла: Channel читает  файла и записывает в Buffer
//Запись в файл: Channel читает из Buffer и записывает в файл

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    private final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/M_NIO_BufferAndChannelReader/BufferAndChannelReader.txt";
    private final static String STRING = "\nКраткие ежедневные занятия помогают накапливать знания.\n" +
            "Исследования доказывают, что студенты, выработавшие привычку регулярно учиться, чаще достигают своих целей.\n" +
            "Выделите немного времени для учебы и установите напоминания с помощью инструментов учебного расписания.";

    public static void main(String[] args) {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(PATH, "rw")) {

            FileChannel channel = randomAccessFile.getChannel();
            //чтение
            ByteBuffer buffer = ByteBuffer.allocate(25); // создали специально буфер всего 25 байт

            StringBuilder stringBuilder = new StringBuilder(); // будем читать и помещать в stringBuilder

            int byteRead = channel.read(buffer); // прочитали и положили в буфер 25 байт - возвращает количество прочитанных байт

            while (byteRead > 0) {                 // проверяем сколько байт прочитано

                System.out.println("Прочитано байт - " + byteRead);  // выводим сколько прочитано

                buffer.flip(); // меняет режим из записи в режим чтение  position = 0;

                while (buffer.hasRemaining()) {      // пока буферу есть что читать

                    stringBuilder.append((char) buffer.get());

                }
                buffer.clear();

                byteRead = channel.read(buffer);  // читаем по 25 байт в цикле, а потом остаток
            }
            System.out.println(stringBuilder);
            //запись
            ByteBuffer buffer1 = ByteBuffer.allocate(STRING.getBytes().length); // создали буфер под длину строки

            buffer1.put(STRING.getBytes()); // записали строку в buffer1

            buffer1.flip();

            channel.write(buffer1);

            // или так
            ByteBuffer buffer3 = ByteBuffer.wrap(STRING.getBytes());
            channel.write(buffer3);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
