package lesson_19_IO_and_NIO.Skillbox.NIO_API_19_6.Channel.FileCopySimple;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileCopySimpleExample {
    //Channel — это базовый интерфейс, который предоставляет API для чтения данных из разных источников и записи в них.
    // Например, так можно работать с файлами, сокетами, буферами и прочим, создавать копии.
    // В Java Channel используется неблокирующий ввод-вывод, который позволяет приложению продолжать работу, пока операция ввода-вывода не завершена.
    public static void main(String[] args) {
        //Класс FileCopySimpleExample:

        //определяет путь до файлов;
        //открывает каналы для чтения и записи;
        //создаёт буфер объёмом в 1 024 байта;
        //записывает данные в целевой FileChannel.
        Path inputPath = Path.of("lesson_19_IO_and_NIO/Skillbox/Parsing_from_Object_to_JSONfile_Jackson/data/input.txt");                //данные из файла
        Path outputPath = Path.of("lesson_19_IO_and_NIO/Skillbox/Parsing_from_Object_to_JSONfile_Jackson/data/output.txt");              // данные в файл создали копию!!!

        try (FileChannel inputChannel = FileChannel.open(inputPath, StandardOpenOption.READ);
             FileChannel outputChannel = FileChannel.open(outputPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inputChannel.read(buffer) != -1) {
                buffer.flip();
                //Метод flip() меняет индексы limit = position, position = 0, mark = −1. Применяется для переключения из режима записи в режим чтения.
                outputChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
