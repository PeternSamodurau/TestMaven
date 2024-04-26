package lesson_19_IO_and_NIO.ChackNorris.B_File_Reader;

//Stream для работы с текстовым файлом.

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/A_File_writer/File_writer.txt";

    public static void main(String[] args) {

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(PATH);

            int character;

            while ((character = fileReader.read())!= -1){                    //метод read() возвращает int

                System.out.print((char) character);

            }
            System.out.println();
            System.out.println("Done!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
