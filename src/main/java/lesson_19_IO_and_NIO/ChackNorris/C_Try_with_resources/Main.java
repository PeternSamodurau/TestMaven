package lesson_19_IO_and_NIO.ChackNorris.C_Try_with_resources;

// чтобы не забывать закрывать ресурсы

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    private final static String STRING = "Часто забывают закрывать поток, поэтому после try  пишут что будет закрываться автоматически\n";

    private final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/C_Try_with_resources/Try_with_resources.txt";

    public static void main(String[] args) {


        try (FileWriter fileWriter =  new FileWriter(PATH,true); // true - будет постоянно дописывать, а не перезаписывать
             FileReader fileReader = new FileReader(PATH)) {

            fileWriter.write(STRING);

            int character;

            while ((character = fileReader.read())!= -1){                    //метод read() возвращает int

                System.out.print((char) character);

            }
            System.out.println();
            System.out.println("Done!");

        } catch (IOException e) {
            System.out.println("Файл не записан!!!!" + e);
        }
    }
}
