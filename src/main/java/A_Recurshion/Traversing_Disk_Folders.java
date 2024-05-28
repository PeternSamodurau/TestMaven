package A_Recurshion;

// рекурсивный обход папок на диске, поиск картинок .jpg

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Traversing_Disk_Folders {
    public static void main(String[] args) {
        // Создаем список файлов
        List<File> fileList = new ArrayList<>();
        // Начинаем поиск файлов с корневой директории "C:\\"
        searchFile(new File("C:\\"),fileList);

        // Выводим абсолютный путь каждого файла в списке
        for (File file: fileList){
            System.out.println(file.getAbsolutePath());
        }
    }

    private static void searchFile(File rootFolder, List<File> fileList) {
        // Проверяем, является ли файл директорией
        if (rootFolder.isDirectory()) {
            // Выводим путь директории, в которой идет поиск
            System.out.println("Поиск в: " + rootFolder.getAbsolutePath());

            // Получаем список файлов в директории
            File[] files = rootFolder.listFiles();

            // Если в директории есть файлы, обрабатываем их
            if (files != null) {
                processFiles(files, fileList);
            }
        }
    }

    private static void processFiles(File[] files, List<File> fileList) {
        // Обрабатываем каждый файл в директории
        for (File file : files) {
            // Если файл является директорией, рекурсивно обрабатываем эту директорию
            if (file.isDirectory()) {
                searchFile(file, fileList);
            } else {
                // Если файл имеет расширение .jpg, добавляем его в список
                if (isJpgFile(file)) {
                    fileList.add(file);
                }
            }
        }
    }

    private static boolean isJpgFile(File file) {
        // Проверяем, имеет ли файл расширение .jpg
        return file.getName().toLowerCase().endsWith(".jpg");
    }
}