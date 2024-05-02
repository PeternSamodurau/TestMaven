package lesson_19_IO_and_NIO.ChackNorris.P_NIO_Files.walkFileTree_method;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

//Значения ENUM FileVisitResult:
//    CONTINUE - означает что нужно продолжать обход по файлам
//    TERMINATE - означает что нужно немедленно прекратить обход по файлам
//    SKIP_SUBTREE - означает что в эту директорию заходить не надо
//    SKIP_SIBLINGS - означает что в данной директории обход по файлам продолжать не нужно

public class MyClassVisitor implements FileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Enter to directory: " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("File name: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error visiting file: " + file.getFileName());
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Exit from directory: " + dir);
        return FileVisitResult.CONTINUE;
    }
}
