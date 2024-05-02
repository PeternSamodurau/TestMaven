package lesson_19_IO_and_NIO.ChackNorris.L_File_class;

// Класс File позволяет управлять информацией о файлах и директориях, не работает на прямую с потоками

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

      private final static String PATH1 = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/L_File_class/file1.txt";
    private final static String PATH2 = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/L_File_class/file2.txt";
    private final static String PATH3 = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/L_File_class";
      private final static String STRING = "Класс File позволяет управлять информацией о файлах и директориях, не работает на прямую с потоками";

    public static void main(String[] args) {
        File file = new File(PATH1);
        File file2 = new File(PATH2);

        //МЕТОДЫ
        System.out.println("Абсолютный путь -"  + file.getAbsolutePath()); // получить абсолютный путь
        System.out.println("Абсолютный ли путь -" +file.isAbsolute());     //проверяет абсолютный ли путь
        System.out.println("Является ли директорией -" + file.isDirectory()); // проверяет является ли директорией
        System.out.println("Существует ли файл -" + file.exists()); // проверяет существует ли файл, не содержимое

        try {
            System.out.println("Создает файл с указанным путем - " + file2.createNewFile());  // или можно создать директорию
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Узнать размер фала в байт - " + file2.length() + " B");  // пустой
      //  System.out.println("Mожно удалить файл он не папка - " + file2.delete());

        File file3 = new File(PATH3);
        File[] files = file3.listFiles();
        System.out.println(Arrays.toString(files));  // посмотреть что в папке

        System.out.println("Проверить скрыта ли папка или файл - " + file.isHidden());
        System.out.println("Проверить можно ли читать файл - " + file.canRead());
        System.out.println("Проверить можно ли писать в файл - " + file.canWrite());
        System.out.println("Проверить можно ли запустить  файл - " + file.canExecute());

    }
}
