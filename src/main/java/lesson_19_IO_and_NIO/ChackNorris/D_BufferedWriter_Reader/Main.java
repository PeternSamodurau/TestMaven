package lesson_19_IO_and_NIO.ChackNorris.D_BufferedWriter_Reader;

import java.io.*;
//Stream для работы с текстовым файлом.
//Буферизация - процесс загрузки части файла во время потока, грузится часть фильма, воспроизводится, в процессе подгружается в youtubу видна
// позволяет достичь большей эффективности при чтении или записи файла
//BufferedWriter - обертка над FilterWriter

// обращаемся к файлу, записываем его в буфер и работаем с буфером по символьно, это быстрее чем посимвольно обращаться к файлу (меньшее количество обращений к файлу)
// может даже одно обращение если файл маленький
public class Main {

    private final static String STRING = "Stream для работы с текстовым файлом.\n" +
            "Буферизация - процесс загрузки части файла во время потока, грузится часть фильма, воспроизводится, в процессе подгружается в youtubу видна\n" +
            "позволяет достичь большей эффективности при чтении или записи файла\n" +
            "BufferedWriter - обертка над FilterWriter\n" +
            "обращаемся к файлу, записываем его в буфер и работаем с буфером по символьно, это быстрее чем посимвольно обращаться к файлу (меньшее количество обращений к файлу)\n" +
            "может даже одно обращение если файл маленький";

    private final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/D_BufferedWriter_Reader/BufferedWriter.txt";

    public static void main(String[] args) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH,true));  // пишем не стирая
             BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))){

            bufferedWriter.write(STRING);                      // пишем в файл из буфера


            int character;

            while ((character = bufferedReader.read())!= -1){   // читаем из буфера

                System.out.print((char) character);
            }
            System.out.println();
            System.out.println("Done!!!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
