package lesson_19_IO_and_NIO.ChackNorris.P_NIO_Files.walkFileTree_method;

//walkFileTre() - метод для обхода дерева папок, удаления, копирования
// логика обхода дерева файлов заключается в классе имплементирующем интерфейс FileVisitor

// FileVisitor интерфейс содержит методы:
// 1.preVisitDirectory - cсрабатывает перед обращением к элементам папки
// 2.visitFile - срабатывает при обращении к файлу
// 3.postVisitDirectory - срабатывает после обращения ко всем элементам папки
// 4.visitFileFailed - срабатывает когда файл по каким то причинам недоступен

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private final static String PATH = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/P_NIO_Files/walkFileTree_method/MyDir";

    public static void main(String[] args) {

        Path path = Paths.get(PATH);

        try {

            Files.walkFileTree(path, new MyClassVisitor());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

