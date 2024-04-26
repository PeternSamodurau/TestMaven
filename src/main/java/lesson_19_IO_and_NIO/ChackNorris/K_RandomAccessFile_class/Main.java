package lesson_19_IO_and_NIO.ChackNorris.K_RandomAccessFile_class;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//RandomAccessFile_class - позволяет читать  по байтам информацию из любого места файла и записывать в любое место файла
// не последовательно как у всех выше
// похоже на курсор который можно перемещать и писать где угодно

public class Main {

    private final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/K_RandomAccessFile_class/rendom.txt";
    private final static String STRING = "//RandomAccessFile_class - позволяет читать по байтам информацию из любого места файла и записывать в любое место файла\n" +
            "// не последовательно как у всех выше\n" +
            "// похоже на курсор который можно перемещать и писать где угодно";

    public static void main(String[] args) {

       try (RandomAccessFile file = new RandomAccessFile(PATH, "rw")) {  // "rw" -можно как писать так и читать файл

           // пишем по байтам
            file.writeBytes(STRING);
            System.out.println("Write done!");

            //читаем по байтам
           int i = file.read();   // читает по элементам
           System.out.println((char) i);

           String s1 = file.readLine();   // читает строку
           System.out.println(s1);

           file.seek(100);          // перемещаем курсот на позицию 100 и выводим c 100 позиции
           String s2 = file.readLine();   // читает строку
           System.out.println(s2);

           long position = file.getFilePointer(); // метод возврашает позицию курсора
           System.out.println(position);

           file.seek(file.length()-1);   //перевели в конец файла
           file.writeBytes("\nЧто-то записали в конец файла с новой строки");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
