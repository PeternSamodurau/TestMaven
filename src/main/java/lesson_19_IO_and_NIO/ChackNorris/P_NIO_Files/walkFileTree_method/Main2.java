package lesson_19_IO_and_NIO.ChackNorris.P_NIO_Files.walkFileTree_method;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main2 {

    private final static String DELETE = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/P_NIO_Files/walkFileTree_method/CopyHere/Dir3";

    public static void main(String[] args) {

        Path path = Paths.get(DELETE);

        try {

            Files.walkFileTree(path, new MyClassVisitorDelete());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
