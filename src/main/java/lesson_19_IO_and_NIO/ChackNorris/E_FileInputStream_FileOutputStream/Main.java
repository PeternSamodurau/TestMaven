package lesson_19_IO_and_NIO.ChackNorris.E_FileInputStream_FileOutputStream;

//FileInputStream_FileOutputStream  - Для работы с бинарными файлами

import java.io.*;

public class Main {
    private final static String PATH_INPUT = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/E_FileInputStream_FileOutputStream/photo_input.jpg";
    private final static String PATH_OUTPUT = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/E_FileInputStream_FileOutputStream/photo_output.jpg";
    public static void main(String[] args) {

        try (FileInputStream inputStream = new FileInputStream(PATH_INPUT);    // читает из файла в программу
             FileOutputStream outputStream = new FileOutputStream(PATH_OUTPUT)){  // пишем в файл из программы

            int i;
            while ((i= inputStream.read())!=-1){       // inputStream читаем и сразу пишем в outputStream

                outputStream.write(i);
            }
            System.out.println("Done! BufferedOutputStream и  BufferedInputStream работают также как BufferedStream...");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

      // BufferedOutputStream и  BufferedInputStream работают также как BufferedStream...

    }
}
