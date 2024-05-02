package lesson_19_IO_and_NIO.ChackNorris.P_NIO_Files.walkFileTree_method;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// class SimpleFileVisitor<T> implements FileVisitor<T> но не нужно переопределять все 4 метода FileVisitor<T>

public class MyClassVisitorCopy extends SimpleFileVisitor<Path> {

    Path source;
    Path destination;

    public MyClassVisitorCopy(Path source, Path destination) {
        this.source = source;
        this.destination = destination;
    }
    // копируем директории
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

        Path newDestination = destination.resolve(source.relativize(dir));


        Files.copy(dir, newDestination, StandardCopyOption.REPLACE_EXISTING);  // StandardCopyOption.REPLACE_EXISTING - чтобы перезаписалось новое имя CopyHere для MyDir

        return FileVisitResult.CONTINUE;
    }
    // копируем файлы
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        Path newDestination = destination.resolve(source.relativize(file));
        Files.copy(file, newDestination);

        return FileVisitResult.CONTINUE;
    }
}
