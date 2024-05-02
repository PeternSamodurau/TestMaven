package lesson_19_IO_and_NIO.ChackNorris.P_NIO_Files.walkFileTree_method;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main1 {

    private final static String SOURCE = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/P_NIO_Files/walkFileTree_method/MyDir";
    private final static String DESTINATION = "src/main/java/lesson_19_IO_and_NIO/ChackNorris/P_NIO_Files/walkFileTree_method/CopyHere";

    public static void main(String[] args) {

        Path source = Paths.get(SOURCE);
        Path destination = Paths.get(DESTINATION);

        try {

            Files.walkFileTree(source, new MyClassVisitorCopy(source, destination));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");

    }
}
